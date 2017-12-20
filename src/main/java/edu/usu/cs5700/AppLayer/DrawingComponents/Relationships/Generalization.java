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
public class Generalization extends Arrow
{
    Generalization(){ }

    Generalization(Point start, Point end){
        this.dashedLine = false;
        this.pointStart = start;
        this.pointEnd = end;
        this.includeLabel = false;
    }

    protected void drawArrowHead(Graphics2D g2, double theta, double x0, double y0) {
        double x1 = x0 - barb * Math.cos(theta + phi);
        double y1 = y0 - barb * Math.sin(theta + phi);
        double x2 = x0 - barb * Math.cos(theta - phi);
        double y2 = y0 - barb * Math.sin(theta - phi);

        g2.setColor(backgroundColor);
        g2.setStroke(new BasicStroke(strokeSize));
        g2.fill(new Polygon(new int[]{(int)x0, (int)x1, (int)x2}, new int[] {(int)y0, (int)y1, (int)y2}, 3));
        g2.setColor(foregroundColor);
        g2.setStroke(new BasicStroke(strokeSize));
        g2.draw(new Polygon(new int[]{(int)x0, (int)x1, (int)x2}, new int[] {(int)y0, (int)y1, (int)y2}, 3));
    }

    @Override
    public Shape Clone()
    {
        return null;
    }
}
