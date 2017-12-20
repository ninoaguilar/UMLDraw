package edu.usu.cs5700.AppLayer.DrawingComponents.Relationships;

import edu.usu.cs5700.AppLayer.DrawingComponents.Shape;

import java.awt.*;
import java.awt.geom.Line2D;

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
public class Dependency extends Arrow
{
    Dependency(){ }

    Dependency(Point start, Point end){
        this.dashedLine = true;
        this.pointStart = start;
        this.pointEnd = end;
        this.includeLabel = true;
        this.roleName = "";
    }

    @Override
    public void Draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(strokeSize));
        super.Draw(g);
    }

    protected void drawArrowHead(Graphics2D g2, double theta, double x0, double y0) {
        double x = x0 - barb * Math.cos(theta + phi);
        double y = y0 - barb * Math.sin(theta + phi);
        g2.draw(new Line2D.Double(x0, y0, x, y));
        x = x0 - barb * Math.cos(theta - phi);
        y = y0 - barb * Math.sin(theta - phi);
        g2.draw(new Line2D.Double(x0, y0, x, y));
    }

    @Override
    public Shape Clone()
    {
        return null;
    }
}
