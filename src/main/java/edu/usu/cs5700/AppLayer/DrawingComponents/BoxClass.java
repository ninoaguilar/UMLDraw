package edu.usu.cs5700.AppLayer.DrawingComponents;

import java.awt.*;

/**
 * ****************************************************
 * File:
 * Created On: 12/14/17
 * Author: Antonino 'Nino' Aguilar
 * A#: A01875439
 * Email: antonino.aguilar@aggiemail.usu.edu
 * Organization: CS3700 - USU - FA17
 * ****************************************************
 */
public class BoxClass extends Shape
{
    private Point cornerStart;
    private Point cornerEnd;
    private String label;
    private Object labelBox;

    public BoxClass() { }

    public void Draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(backgroundColor);
        g2.fillRect(cornerStart.x, cornerStart.y, cornerEnd.x-cornerStart.x, cornerEnd.y-cornerStart.y);
        g2.setColor(foregroundColor);
        g2.drawString(label, (cornerStart.x +cornerEnd.x)/2, (cornerStart.y + cornerEnd.y)/2);
        g2.setPaint(foregroundColor);
        g2.setStroke(new BasicStroke(strokeSize));
        g2.drawRect(cornerStart.x, cornerStart.y, cornerEnd.x-cornerStart.x, cornerEnd.y-cornerStart.y);
    }

    @Override
    public Shape Clone()
    {
        return null;
    }

    public Point getCornerStart()
    {
        return cornerStart;
    }

    public void setCornerStart(Point cornerStart)
    {
        this.cornerStart = cornerStart;
    }

    public Point getCornerEnd()
    {
        return cornerEnd;
    }

    public void setCornerEnd(Point cornerEnd)
    {
        this.cornerEnd = cornerEnd;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public Object getLabelBox()
    {
        return labelBox;
    }

    public void setLabelBox(Object labelBox)
    {
        this.labelBox = labelBox;
    }
}
