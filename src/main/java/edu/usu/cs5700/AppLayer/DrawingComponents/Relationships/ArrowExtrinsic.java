package edu.usu.cs5700.AppLayer.DrawingComponents.Relationships;

import java.awt.*;

/**
 * ****************************************************
 * File:
 * Created On: 12/10/17
 * Author: Antonino 'Nino' Aguilar
 * A#: A01875439
 * Email: antonino.aguilar@aggiemail.usu.edu
 * Organization: CS3700 - USU - FA17
 * ****************************************************
 */
public class ArrowExtrinsic
{
    public String arrowType;
    public Point pointStart;
    public Point pointEnd;
    public String roleName;
    public boolean IsSelected;

    public String getArrowType()
    {
        return arrowType;
    }

    public void setArrowType(String arrowType)
    {
        this.arrowType = arrowType;
    }

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
