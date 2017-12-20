/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.Command;

import edu.usu.cs5700.AppLayer.DrawingComponents.Shape;
import java.awt.Point;

/**
 *
 * @author nino
 */
public class SelectCommand extends Command {
    
    private Point location;
    private Shape element;
    private boolean originalState;
    
    protected SelectCommand(Object ... commandParameters) {
        if (commandParameters.length > 0) {
            location = (Point) commandParameters[0];
        }
    }

    @Override
    public boolean Execute() {
        element = TargetDrawing.FindElementAtPosition(location);
        if(element == null) {
            return false;
        }
        
        originalState = element.IsSelected;
        element.IsSelected = !originalState;
        
        TargetDrawing.IsDirty = true;
        
        return true;
    }

    @Override
    void Undo() {
        if(element.IsSelected == originalState) {
            return;
        }
        
        element.IsSelected = originalState;
        TargetDrawing.IsDirty = true;
        
    }

    @Override
    void Redo() {
        if(element.IsSelected != originalState) {
            return;
        }
        
        element.IsSelected = !originalState;
        TargetDrawing.IsDirty = true;
    }
    
}
