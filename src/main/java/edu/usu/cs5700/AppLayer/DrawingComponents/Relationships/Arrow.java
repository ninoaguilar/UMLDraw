package edu.usu.cs5700.AppLayer.DrawingComponents.Relationships;

import edu.usu.cs5700.AppLayer.DrawingComponents.Shape;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * ****************************************************
 * File:
 * Created On: 10/28/17
 * Author: Antonino 'Nino' Aguilar
 * A#: A01875439
 * Email: antonino.aguilar@aggiemail.usu.edu
 * Organization: CS3700 - USU - FA17
 * ****************************************************
 */
public abstract class Arrow extends Shape
{
    protected Point pointStart;
    protected Point pointEnd;
    protected Point Location;
    protected boolean IsSelected = false;
    protected String roleName;

    // Default properties for arrowhead
    protected final int barb = 15;
    protected final double phi = Math.PI/6;
    protected boolean dashedLine = false;
    protected boolean includeLabel = false;
    final static float dash1[] = {10.0f};
    final BasicStroke dashed = new BasicStroke(strokeSize,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f, dash1, 0.0f);


    public void Draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Arrow(g2, pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
    }

    public void Arrow(Graphics2D g2, double x1, double y1, double x2, double y2) {
        double theta;
        if(dashedLine) g2.setStroke(dashed);
        if(includeLabel) {
            g2.drawString(roleName, (int) (x1+x2)/2, (int)(y1+y2)/2);
        }
        else g2.setStroke(new BasicStroke(strokeSize));
        g2.setColor(foregroundColor);
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
        // Draw this arrow head at point x2, y2 and measure
        // angle theta relative to same point, ie, y2 - and x2 -
        theta = Math.atan2(y2 - y1, x2 - x1);
        drawArrowHead(g2, theta, x2, y2);
    }


    abstract void drawArrowHead(Graphics2D g2, double theta, double x0, double y0);

    /**
     *
     * Getter and setters
     *
     */

    public Point getPointStart()
    {
        return pointStart;
    }

    public void setPointStart(Point pointStart)
    {
        this.pointStart = pointStart;
    }

    public Point getPointEnd()
    {
        return pointEnd;
    }

    public void setPointEnd(Point pointEnd)
    {
        this.pointEnd = pointEnd;
    }

    public Point getLocation()
    {
        return Location;
    }

    public void setLocation(Point location)
    {
        Location = location;
    }

    public boolean isSelected()
    {
        return IsSelected;
    }

    public void setSelected(boolean selected)
    {
        IsSelected = selected;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
}
