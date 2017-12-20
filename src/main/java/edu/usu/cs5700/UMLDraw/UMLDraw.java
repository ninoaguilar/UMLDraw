package edu.usu.cs5700.UMLDraw;

import javax.swing.SwingUtilities;
/**
 *
 * @author nino
 */
public class UMLDraw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> CreateandRun());
    }
    
    private static void CreateandRun() {
        MainForm form = new MainForm();
        form.setVisible(true);
    }
    
}
