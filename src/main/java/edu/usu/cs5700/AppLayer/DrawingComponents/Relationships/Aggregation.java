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
public class Aggregation extends Arrow
{
    Aggregation(){ }

    Aggregation(Point start, Point end){
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

        double vx = this.pointEnd.x - this.pointStart.x;
        double vy = this.pointEnd.y - this.pointStart.y;
        double vNorm = Math.sqrt(Math.pow(vx,2)+ Math.pow(vy,2));
        double ux = vx / vNorm;
        double uy = vy / vNorm;
        double x3 = pointEnd.x - 30*ux;
        double y3 = pointEnd.y - 30*uy;

        if(Math.abs(vx)<1 && Math.abs(vy) <1){
            double tempX = x2 - x1;
            double tempY = y2 - y1;
            x3 = pointStart.x - tempY*1.5;
            y3 = pointStart.y - tempX*1.5;
        }

        g2.setPaint(backgroundColor);
        g2.setStroke(new BasicStroke(strokeSize));
        g2.fillPolygon(new int[]{(int)x0, (int)x1, (int)x3, (int)x2}, new int[] {(int)y0, (int)y1, (int)y3, (int)y2}, 4);
        g2.setColor(foregroundColor);
        g2.setStroke(new BasicStroke(strokeSize));
        g2.draw(new Polygon(new int[]{(int)x0, (int)x1, (int)x3, (int)x2}, new int[] {(int)y0, (int)y1, (int)y3,(int)y2}, 4));
    }

    @Override
    public Shape Clone()
    {
        return null;
    }
}
