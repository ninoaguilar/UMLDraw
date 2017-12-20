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
public class RemoveSelectedCommand extends Command {
    private List<Shape> deletedElements;
    protected RemoveSelectedCommand() { }
    
    @Override
    public boolean Execute() {
        deletedElements = TargetDrawing.DeleteAllSelected();
        return deletedElements != null && deletedElements.size() > 0;
    }

    @Override
    void Undo() {
        if (deletedElements == null || deletedElements.size() == 0 ) {
            return;
        }
        
        for (Shape element : deletedElements) {
            if (TargetDrawing != null) TargetDrawing.Add(element);
        }
    }

    @Override
    void Redo() {
        if (deletedElements == null || deletedElements.size() == 0) return;
        
        for (Shape element : deletedElements) {
            if (TargetDrawing != null) TargetDrawing.DeleteShape(element);
        }
    }
    
}
