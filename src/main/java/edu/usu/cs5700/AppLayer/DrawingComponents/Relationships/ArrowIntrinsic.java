package edu.usu.cs5700.AppLayer.DrawingComponents.Relationships;

import java.awt.*;
import java.util.Locale;

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
public class ArrowIntrinsic
{
    public String TreeType;

    public Arrow LoadFromResource(String shapeName)
    {
        Arrow shape = null;

        switch (shapeName) {
            case "Aggregation":
                shape = new Aggregation();
                break;
            case "Binary":
                shape = new Binary();
                break;
            case "Composition":
                shape = new Composition();
                break;
            case "Dependency":
                shape = new Dependency();
                break;
            case "Generalization":
                shape = new Generalization();
                break;
        }

        return shape;
    }

    public void DrawFromResource(Graphics g, ArrowExtrinsic extrinsic)
    {
        Arrow shape = null;

        switch (extrinsic.getArrowType().trim().toUpperCase(Locale.US)) {
            case "AGGREGATION":
                shape = new Aggregation(extrinsic.getPointStart(), extrinsic.getPointEnd());
                break;
            case "ASSOCIATION":
                shape = new Binary(extrinsic.getPointStart(), extrinsic.getPointEnd());
                break;
            case "COMPOSITION":
                shape = new Composition(extrinsic.getPointStart(), extrinsic.getPointEnd());
                break;
            case "DEPENDENCY":
                shape = new Dependency(extrinsic.getPointStart(), extrinsic.getPointEnd());
                break;
            case "GENERALIZATION":
                shape = new Generalization(extrinsic.getPointStart(), extrinsic.getPointEnd());
                break;
            default:
                System.err.println(extrinsic.getArrowType());
        }

        shape.Draw(g);
    }
}
