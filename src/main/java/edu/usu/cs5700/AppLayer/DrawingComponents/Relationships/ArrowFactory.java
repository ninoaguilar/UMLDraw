package edu.usu.cs5700.AppLayer.DrawingComponents.Relationships;

import java.util.HashMap;
import java.util.Map;

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
public class ArrowFactory
{
    /**
     * Singleton
     */
    private static ArrowFactory instance;

    private ArrowFactory() { }

    public synchronized static ArrowFactory getInstance()
    {
        if (instance == null) {
            instance = new ArrowFactory();
        }

        return instance;
    }

    /**
     * Flyweight
     */

    public String referenceType;

    private static final Map<String, ArrowIntrinsic> sharedArrows = new HashMap<>();

    public Arrow getArrow(ArrowExtrinsic extrinsicState)
    {
        String arrowType = extrinsicState.getArrowType();
        ArrowIntrinsic arrowIntrinsic;

        if(sharedArrows.containsKey(arrowType)) {
            arrowIntrinsic = sharedArrows.get(arrowType);
        } else {
            arrowIntrinsic = new ArrowIntrinsic();
            arrowIntrinsic.LoadFromResource(arrowType);
            sharedArrows.put(arrowType, arrowIntrinsic);
        }

        return new ArrowAllStates(arrowIntrinsic, extrinsicState);
    }
}
