/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.Command;

import java.awt.Point;

import edu.usu.cs5700.AppLayer.DrawingComponents.Relationships.Arrow;
import edu.usu.cs5700.AppLayer.DrawingComponents.Relationships.ArrowExtrinsic;
import edu.usu.cs5700.AppLayer.DrawingComponents.Relationships.ArrowFactory;

/**
 *
 * @author nino
 */
public class AddArrowCommand extends Command {
    private String arrowType;
    private Point start;
    private Point end;
    private String label;
    private Arrow arrow;
    ArrowFactory arrowFactory = ArrowFactory.getInstance();
    
    protected AddArrowCommand() { };
    
    protected AddArrowCommand(Object ... commandParameters)
    {
        if (commandParameters.length > 0) {
            arrowType = (String)commandParameters[0];
        }

        if (commandParameters.length > 1) {
            start = (Point) commandParameters[1];
        }
        
        if (commandParameters.length > 2) {
            end = (Point) commandParameters[2];
        }

        if (commandParameters.length > 3) {
            label = (String) commandParameters[3];
        }
    }

    @Override
    public boolean Execute() {
        if(start == null || end == null) {
            return false;
        }
        
        ArrowExtrinsic extrinsicState = new ArrowExtrinsic();

        extrinsicState.setArrowType(arrowType);
        extrinsicState.setPointStart(start);
        extrinsicState.setPointEnd(end);
        extrinsicState.setRoleName(label);

        arrow = arrowFactory.getArrow(extrinsicState);

        arrow.setPointStart(start);
        arrow.setPointEnd(end);
        arrow.setRoleName(label);

        TargetDrawing.Add(arrow);
        
        return true;
    }

    @Override
    void Undo() {
        TargetDrawing.DeleteShape(arrow);
    }

    @Override
    void Redo() {
        TargetDrawing.Add(arrow);
    }
    
}
