package com.emersonjason.puzzle1.PuzzleSolutions;

import com.emersonjason.puzzle1.IntArrayBuilder;
import com.emersonjason.puzzle1.PuzzleAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2Ribbon implements PuzzleAlgorithm {
    private final static String TAG = Day2Ribbon.class.getSimpleName();
    private final static int LENGTH = 0;
    private final static int WIDTH = 1;
    private final static int HEIGHT = 2;
    public List<int[]> intArrays;
    private String[] tokens;

    public Day2Ribbon() {
        this.intArrays = new ArrayList<>();
    }

    public double getResult(String fileData) {
        tokenizeFileData(fileData);
        convertTokensToIntArrays();
        return findRibbonAndBowLength();
    }

    public void tokenizeFileData(String fileData) {
        String delims = "[x]";
        tokens = fileData.split(delims);
    }

    public void convertTokensToIntArrays() {
        IntArrayBuilder builder = new IntArrayBuilder();
        for (int i = 0; i != tokens.length; i++) {
            builder.stringToInt(tokens[i]);
        }
        intArrays = builder.getIntArrays();
    }

    public double findRibbonAndBowLength() {
        double totalRibbonLength = 0;
        for (int[] intArr : intArrays) {
            List<Integer> dimensions = new ArrayList<>();
            dimensions.add(intArr[LENGTH]);
            dimensions.add(intArr[WIDTH]);
            dimensions.add(intArr[HEIGHT]);
            Collections.sort(dimensions);

            double ribbon = (2 * dimensions.get(0)) +
                    (2 * dimensions.get(1));
            double ribbonBow = intArr[LENGTH] * intArr[WIDTH] *
                    intArr[HEIGHT];
            totalRibbonLength += ribbon + ribbonBow;
        }
        return totalRibbonLength;
    }

    public void extraAppend(StringBuilder txt) {
        txt.append("x");
    }
}