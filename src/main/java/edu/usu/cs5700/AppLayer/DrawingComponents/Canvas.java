/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.DrawingComponents;

/**
 *
 * @author nino
 */

import edu.usu.cs5700.AppLayer.Command.CommandFactory;
import edu.usu.cs5700.AppLayer.DrawingComponents.Relationships.Arrow;
import edu.usu.cs5700.AppLayer.DrawingComponents.Relationships.ArrowExtrinsic;
import edu.usu.cs5700.AppLayer.DrawingComponents.Relationships.ArrowFactory;

import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import javax.swing.*;

/**
 * ****************************************************
 * File:
 * Created On: 10/30/17
 * Author: Antonino 'Nino' Aguilar
 * A#: A01875439
 * Email: antonino.aguilar@aggiemail.usu.edu
 * Organization: CS3700 - USU - FA17
 * ****************************************************
 */
public class Canvas extends JPanel implements Observer
{
    public enum PossibleModes
    {
        None,
        UMLClassDrawing,
        UMLRelationshipDrawing,
        Selection,
    }

    public PossibleModes mode = PossibleModes.None;

    private Point startPoint = null;
    private Point endPoint = null;
    private ArrowFactory shapeFactory = ArrowFactory.getInstance();
    private String selectedShape = null;
    private Drawing drawing = new Drawing();

    public Canvas()
    {
        CommandFactory.getInstance().targetDrawing = drawing;
        setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        drawing.Draw(g, false);

        switch (mode) {
            case UMLRelationshipDrawing:
                if (startPoint != null && endPoint != null) drawRubberBandLine(g);
                break;
            case UMLClassDrawing:
                if (startPoint != null && endPoint != null) drawRubberBandBox(g);
        }
    }

    public void drawRubberBandLine(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.GRAY);
        g2.setStroke(new BasicStroke(1));
        g2.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    public void drawRubberBandBox(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.GRAY);
        g2.setStroke(new BasicStroke(1));
        g2.drawRect(startPoint.x, startPoint.y, endPoint.x - startPoint.x,
                endPoint.y - startPoint.y);
    }

    @Override
    public void update(java.util.Observable o, Object arg)
    {
        drawing = (Drawing) o;
    }

    public void resetPositions() {
        this.startPoint = null;
        this.endPoint = null;
    }

    public Drawing getDrawing()
    {
        return drawing;
    }

    public PossibleModes getMode()
    {
        return mode;
    }

    public void setMode(PossibleModes mode)
    {
        this.mode = mode;
    }

    public Point getStartPoint()
    {
        return startPoint;
    }

    public void setStartPoint(Point startPoint)
    {
        this.startPoint = startPoint;
    }

    public Point getEndPoint()
    {
        return endPoint;
    }

    public void setEndPoint(Point endPoint)
    {
        this.endPoint = endPoint;
    }

    public ArrowFactory getShapeFactory()
    {
        return shapeFactory;
    }

    public void setShapeFactory(ArrowFactory shapeFactory)
    {
        this.shapeFactory = shapeFactory;
    }

    public String getSelectedShape()
    {
        return selectedShape;
    }

    public void setSelectedShape(String selectedShape)
    {
        this.selectedShape = selectedShape;
    }

    public void setDrawing(Drawing drawing)
    {
        this.drawing = drawing;
    }
}

