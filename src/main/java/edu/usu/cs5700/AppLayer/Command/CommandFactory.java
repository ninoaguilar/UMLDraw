/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.Command;

import edu.usu.cs5700.AppLayer.DrawingComponents.Drawing;
import java.util.Locale;

/**
 *
 * @author Antonino Aguilar
 */
public class CommandFactory {
    private static CommandFactory instance;
    
    private CommandFactory() { }
    
    public synchronized static CommandFactory getInstance(){
        if(instance == null) {
            instance = new CommandFactory();
        }
        
        return instance;
    }
    
    public Drawing targetDrawing;
    public Invoker invoker;
    
    public void CreateAndDo(String commandType, Object... commandParameters)
    {
        if (commandType == null || commandType.isEmpty()) { return; /* Do nothing */ }
        if (targetDrawing == null) { return; /* Do nothing */ }
        
        Command command = null;
        switch (commandType.trim().toUpperCase(Locale.US))
        {
            case "NEW":
                command = new NewCommand();
                break;
            case "ADDARROW":
                command = new AddArrowCommand(commandParameters);
                break;
            case "ADDCLASS":
                command = new AddBoxCommand(commandParameters);
                break;
            case "REMOVE":
                command = new RemoveSelectedCommand();
                break;
            case "SELECT":
                command = new SelectCommand(commandParameters);
                break;
            case "DESELECT":
                command = new DeselectAllCommand();
                break;
            case "LOAD":
                command = new LoadCommand(commandParameters);
                break;
            case "SAVE":
                command = new SaveCommand(commandParameters);
                break;
        }
        
        if(command != null) {
            command.TargetDrawing = targetDrawing;
            invoker.EnqueueCommandForExecution(command);
        }
    }


    public Drawing getTargetDrawing() {
        return targetDrawing;
    }

    public void setTargetDrawing(Drawing targetDrawing) {
        this.targetDrawing = targetDrawing;
    }

    public Invoker getInvoker() {
        return invoker;
    }

    public void setInvoker(Invoker invoker) {
        this.invoker = invoker;
    }
    
}