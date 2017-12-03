package org.ulco;

public class ID {
    static private int ID = 0;
    private ID(){}
    private static ID id = new ID();

    private static ID getInst() {
        return id;
    }

    public static int getID() {
        return getInst().ID++;
    }
}