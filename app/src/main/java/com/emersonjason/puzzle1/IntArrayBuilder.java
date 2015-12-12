package com.emersonjason.puzzle1;

import java.util.ArrayList;
import java.util.List;

public class IntArrayBuilder {
    private final static int MAX_ARRAY_LENGTH = 3;
    public List<int[]> intArrays;
    private int arrayCount = 0;
    private int elementCount = 0;

    public IntArrayBuilder() {
        this.intArrays = new ArrayList<>();
        addIntArray();
    }

    private void addIntArray() {
        intArrays.add(new int[3]);
    }

    public void stringToInt(String s) {
        if (arrayCount < MAX_ARRAY_LENGTH) {
            addInteger(s);
        } else {
            arrayCount = 0;
            addIntArray();
            elementCount++;
            addInteger(s);
        }
    }

    public void addInteger(String s) {
        intArrays.get(elementCount)[arrayCount] = Integer.parseInt(s);
        arrayCount++;
    }

    public List<int[]> getIntArrays() {
        return intArrays;
    }
}
