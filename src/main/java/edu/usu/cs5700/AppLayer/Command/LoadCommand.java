/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.Command;


import edu.usu.cs5700.AppLayer.DrawingComponents.Shape;
import java.util.List;

/**
 *
 * @author nino
 */
public class LoadCommand extends Command {
    private String filename;
    private List<Shape> previousElements;
    
    protected LoadCommand() { };
    
    protected LoadCommand(Object... commandParameters) {
        if (commandParameters.length > 0) {
            filename = (String)commandParameters[0];
        }
    }
    
    
    @Override
    public boolean Execute() {
        previousElements = TargetDrawing.GetCloneOfElement();
        
        if (TargetDrawing != null) {
            TargetDrawing.Clear();
        }
        
        //ReadFile
        
        return true;
        
    }

    @Override
    void Undo() {
        TargetDrawing.Clear();
        
        if (previousElements == null || previousElements.isEmpty()) {
            return; /* Do Nothing */
        }
        
        for (Shape element : previousElements) {
            if (TargetDrawing != null) {
                TargetDrawing.Add(element);
            }
        }
        
    }

    @Override
    void Redo() {
        Execute();
    }
    
}
