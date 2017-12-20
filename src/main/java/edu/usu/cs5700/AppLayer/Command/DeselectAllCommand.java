/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.Command;

import edu.usu.cs5700.AppLayer.DrawingComponents.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nino
 */
public class DeselectAllCommand extends Command{
    private List<Shape> selectedElements = new ArrayList<>();
    
    protected DeselectAllCommand() { }
    

    @Override
    public boolean Execute() {
        if (TargetDrawing != null) {
            selectedElements = TargetDrawing.DeselectAll();
        }
        
        return selectedElements != null && selectedElements.size() > 0;
    }

    @Override
    void Undo() {
        if (selectedElements == null || selectedElements.isEmpty()) {
            return;
        }
        
        for (Shape element : selectedElements) {
            if (!element.IsSelected) {
                element.IsSelected = true;
                TargetDrawing.IsDirty = true;
            }
        }
    }

    @Override
    void Redo() {
        if (selectedElements == null || selectedElements.isEmpty()) {
            return;
        }
        
        for (Shape element : selectedElements) {
            if (element.IsSelected) {
                element.IsSelected = false;
                TargetDrawing.IsDirty = true;
            }
        }
    }
    
}
