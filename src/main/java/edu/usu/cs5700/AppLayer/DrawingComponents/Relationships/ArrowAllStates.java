package edu.usu.cs5700.AppLayer.DrawingComponents.Relationships;


import edu.usu.cs5700.AppLayer.DrawingComponents.Shape;

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
public class ArrowAllStates extends Arrow
{
    protected ArrowIntrinsic shapeStateIntrinsic;
    protected ArrowExtrinsic shapeStateExtrinsic;

    protected ArrowAllStates(ArrowIntrinsic sharedLook, ArrowExtrinsic nonSharedLocation) {
        shapeStateIntrinsic = sharedLook;
        shapeStateExtrinsic = nonSharedLocation;
    }

    @Override
    public Shape Clone()
    {
        return null;
    }

    @Override
    public void Draw(Graphics g) {

        if (g == null) return;

        shapeStateIntrinsic.DrawFromResource(g, shapeStateExtrinsic);


    }

    @Override
    void drawArrowHead(Graphics2D g2, double theta, double x0, double y0)
    {
        //
    }


    @Override
    public boolean isSelected()
    {
        return shapeStateExtrinsic.IsSelected;
    }

    @Override
    public void setSelected(boolean selected)
    {
        shapeStateExtrinsic.IsSelected = selected;
    }
}
