/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.Command;

import edu.usu.cs5700.AppLayer.DrawingComponents.BoxClass;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author nino
 */
public class AddBoxCommand extends Command {
    private Point cornerStart;
    private Point cornerEnd;
    private String label;
    private Object labelBox;
    private BoxClass boxClass;

    protected AddBoxCommand() {}

    protected AddBoxCommand(Object ... commandParameters) {
        if (commandParameters.length > 0)
            label = (String) commandParameters[0];

        if (commandParameters.length > 1)
            cornerStart = (Point) commandParameters[1];

        if (commandParameters.length > 1)
            cornerEnd = (Point) commandParameters[2];
    }

    @Override
    public boolean Execute() {
        if (label == null || cornerStart == null || cornerEnd == null) return false;

        boxClass = new BoxClass();

        boxClass.setLabel(label);
        boxClass.setCornerStart(cornerStart);
        boxClass.setCornerEnd(cornerEnd);

        TargetDrawing.Add(boxClass);

        return true;
    }

    @Override
    void Undo() {
        TargetDrawing.DeleteShape(boxClass);
    }

    @Override
    void Redo() {
        TargetDrawing.Add(boxClass);
    }
    
}
