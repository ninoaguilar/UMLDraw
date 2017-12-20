package edu.usu.cs5700.AppLayer.Command;

import edu.usu.cs5700.AppLayer.DrawingComponents.Drawing;
import edu.usu.cs5700.AppLayer.DrawingComponents.Shape;

import java.awt.*;
import java.util.ArrayList;

/**
 * ****************************************************
 * File:
 * Created On: 12/15/17
 * Author: Antonino 'Nino' Aguilar
 * A#: A01875439
 * Email: antonino.aguilar@aggiemail.usu.edu
 * Organization: CS3700 - USU - FA17
 * ****************************************************
 */
public class UpdateBackgroundCommand extends Command
{
    ArrayList<Color> previousColors = new ArrayList<Color>();
    Color currentColor;
    int previousColorIndex = -1;

    protected UpdateBackgroundCommand() {}

    protected UpdateBackgroundCommand(Object ... commandParameters) {
        if (commandParameters.length > 0) {
            currentColor = (Color) commandParameters[0];
            previousColors.add(currentColor);
            previousColorIndex++;
        }

    }

    @Override
    public boolean Execute() {
        TargetDrawing.updateBackgroundColor(currentColor);
        return true;
    }

    @Override
    void Undo() {
        previousColorIndex--;
        TargetDrawing.updateBackgroundColor(previousColors.get(previousColorIndex));
    }

    @Override
    void Redo() {
        previousColorIndex++;
        TargetDrawing.updateBackgroundColor(previousColors.get(previousColorIndex));
    }
}
