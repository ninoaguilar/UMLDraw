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
public class NewCommand extends Command {
    
    private List<Shape> previousUMLElements;

    @Override
    public boolean Execute() {
        previousUMLElements = TargetDrawing.GetCloneOfElement();
        
        if (TargetDrawing != null) {
            TargetDrawing.Clear();
        }
        
        return previousUMLElements != null && previousUMLElements.size() > 0;
        
    }

    @Override
    void Undo() {
        if (previousUMLElements == null  || previousUMLElements.isEmpty()) {
            return;
        }
        
        for (Shape element : previousUMLElements) {
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
