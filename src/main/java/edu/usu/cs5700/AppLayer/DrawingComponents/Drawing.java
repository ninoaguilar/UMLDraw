/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usu.cs5700.AppLayer.DrawingComponents;

import edu.usu.cs5700.AppLayer.DrawingComponents.Relationships.Arrow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author nino
 */
public class Drawing extends Observable {
    //Gson gson = new Gson();

    private Color backgroundColor = Color.BLACK;
    private Color foregroundColor = Color.WHITE;
    
    private final List<Shape> shapes = new ArrayList<>();

    public boolean IsDirty = true;

    public boolean isIsDirty() {
        return IsDirty;
    }

    public void setIsDirty(boolean IsDirty) {
        this.IsDirty = IsDirty;
    }
    
    public synchronized List<Shape> GetCloneOfElement() {
        List<Shape> cloneList = new ArrayList<>();
        shapes.forEach((element) -> {
            cloneList.add(element.Clone());
        });
        
        return cloneList;
    }
    
    public synchronized void Clear() {
        shapes.clear();
        IsDirty = true;

        setChanged();
        notifyObservers();
    }
    
    public synchronized void LoadFromStream(String stream) {
        // loadElements = ... as List<UMLElement>
        
        // for ( Element elment in loadedElements) {
        //    WithAllState tmpUMLElement = (UMLElementWithAllState)element
        //    if (EML
        //}
        
    }
    
    public synchronized void SaveToStream(String stream) {
        //JsonSerializer
    }
    
    public synchronized void Add(Shape umlElement) {
        if (umlElement == null) {
            return;
        }
        
        shapes.add(umlElement);
        IsDirty = true;

        setChanged();
        notifyObservers();
    }
    
    public synchronized List<Shape> DeleteAllSelected() {
        List<Shape> elementsToDelete = new ArrayList<>();
        
        shapes.stream().filter((element) -> (element.IsSelected)).map((element) -> {
            elementsToDelete.add(element);
            return element;
        }).forEachOrdered((element) -> {
            shapes.remove(element);
        });
        
        IsDirty = true;

        setChanged();
        notifyObservers();
        
        return elementsToDelete;
    }
    
    public synchronized void DeleteShape(Shape shape) {
        shapes.remove(shape);
        IsDirty = true;

        setChanged();
        notifyObservers();
    }
    
    public synchronized Shape FindElementAtPosition(Point point) {
        Shape result = null;
        
        for (Shape element : shapes) {
            if (element.ContainsPoint(point)) {
                result = element;
            }
        }
        
        return result;
    }
    
    public synchronized List<Shape> DeselectAll() {
        List<Shape> selectedElements = new ArrayList<>();
        
        shapes.stream().filter((t) -> (t.IsSelected)).map((t) -> {
            selectedElements.add(t);
            return t;
        }).forEachOrdered((t) -> {
            t.IsSelected = false;
        });
        
        IsDirty = true;

        return selectedElements;
    }
    
    public synchronized void Draw(Graphics graphics, boolean redrawEvenIfNotDirty) {
        if (!IsDirty && redrawEvenIfNotDirty) {
            return;
        }

        if (shapes.isEmpty()) {
            return;
        }

        Graphics2D g2 = (Graphics2D)graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for(Shape shape : shapes) {
            shape.Draw(g2);
        }

        IsDirty = false;
    }

    public void updateBackgroundColor(Color color) {
        for (Shape shape: shapes) {
            shape.backgroundColor = color;
        }
    }


    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    void Add(Arrow shape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
