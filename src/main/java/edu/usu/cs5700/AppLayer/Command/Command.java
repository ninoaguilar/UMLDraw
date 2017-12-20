/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.Command;

import edu.usu.cs5700.AppLayer.DrawingComponents.Drawing;

/**
 *
 * @author Antonino Aguilar
 */
public abstract class Command {
    public Drawing TargetDrawing;
    
    public abstract boolean Execute();
    abstract void Undo();
    abstract void Redo();

}
