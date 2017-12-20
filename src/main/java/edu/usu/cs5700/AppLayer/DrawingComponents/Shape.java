/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.DrawingComponents;

import java.awt.*;

/**
 *
 * @author nino
 */
public abstract class Shape
{
    public Color foregroundColor = Color.BLACK;
    public Color backgroundColor = Color.WHITE;
    public int strokeSize = 3;
    public boolean IsSelected = false;

    public abstract Shape Clone();

    public void Draw(Graphics g) { }

    public boolean ContainsPoint(Point point) {
        return false;
    }
}
