/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.Command;

/**
 *
 * @author nino
 */
public class RedoCommand extends Command {

    @Override
    public boolean Execute() {
        return false;
    }

    @Override
    void Undo() {
        //Do Nothing
    }

    @Override
    void Redo() {
        //Do Nothing
    }
    
}
