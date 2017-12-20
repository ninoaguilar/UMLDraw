/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.Command;

import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nino
 */
public class Invoker {
    private Thread worker;
    private boolean keepGoing;
    
    private final ConcurrentLinkedQueue<Command> todoQueue = new ConcurrentLinkedQueue<>();
    private final AutoResetEvent endueOccurred = new AutoResetEvent(false);
    
    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();
    
    public void Start() {
        keepGoing = true;
        worker = new Thread(() ->
                Run()
        );
        worker.start();
    }
    
    public void Stop() {
        keepGoing = false;
    }
    
    public void EnqueueCommandForExecution(Command cmd) {
        if (cmd == null) { return; /* Do nothing */}
        todoQueue.offer(cmd);
        endueOccurred.set();
    }
    
    public void Undo() {
        EnqueueCommandForExecution(new UndoCommand());
    }
    
    public void Redo() {
        EnqueueCommandForExecution(new RedoCommand());
    }
    
    private void Run() {
        while (keepGoing) {
            try {
                Command cmd = todoQueue.poll();
                if (cmd != null) {
                    if(cmd.getClass() == UndoCommand.class) {
                        ExecuteUndo();
                    } else if (cmd.getClass() == RedoCommand.class) {
                        ExecuteRedo();
                    } else {
                        if (cmd.Execute()) {
                            undoStack.add(cmd);
                        }
                    }
                }
                else {
                    endueOccurred.waitOne(100);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Invoker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void ExecuteUndo() {
        if (undoStack.size() <= 0) {
            return;
        }
        
        Command cmd = undoStack.pop();
        cmd.Undo();
        redoStack.add(cmd);
    }
    
    private void ExecuteRedo() {
        if (redoStack.size() <= 0) {
            return;
        }
        
        Command cmd = redoStack.pop();
        cmd.Redo();
        undoStack.add(cmd);
    }

    public ConcurrentLinkedQueue<Command> getTodoQueue() {
        return todoQueue;
    }

    public Stack<Command> getUndoStack() {
        return undoStack;
    }

    public Stack<Command> getRedoStack() {
        return redoStack;
    }
    
    
}
