package edu.usu.cs5700.AppLayer.DrawingComponents.Relationships;

import edu.usu.cs5700.AppLayer.DrawingComponents.Shape;

import java.awt.*;

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
public class Binary extends Arrow
{
    Binary(){ }

    Binary(Point start, Point end){
        this.dashedLine = false;
        this.pointStart = start;
        this.pointEnd = end;
        this.includeLabel = true;
        this.roleName = "test";
    }

    @Override
    public Shape Clone()
    {
        return null;
    }

    @Override
    public void Draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(strokeSize));
        super.Draw(g2);
    }

    @Override
    void drawArrowHead(Graphics2D g2, double theta, double x0, double y0)
    {
        //None
    }
}
