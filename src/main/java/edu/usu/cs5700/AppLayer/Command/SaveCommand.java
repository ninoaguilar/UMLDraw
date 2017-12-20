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
public class SaveCommand extends Command {
    private static String filename;
    
    protected SaveCommand(Object ... commandParameters){
        if (commandParameters.length > 0) {
            filename = (String)commandParameters[0];
        }
    }

    @Override
    public boolean Execute() {
        // Save file
        
        return true;
    }

    @Override
    void Undo() {
        // Do nothing -- we don't want to delete the saved file.
    }

    @Override
    void Redo() {
        Execute();
    }
    
}
