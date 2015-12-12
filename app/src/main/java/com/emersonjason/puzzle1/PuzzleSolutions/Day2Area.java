package com.emersonjason.puzzle1.PuzzleSolutions;

import com.emersonjason.puzzle1.IntArrayBuilder;
import com.emersonjason.puzzle1.PuzzleAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2Area implements PuzzleAlgorithm {
    private final static String TAG = Day2Area.class.getSimpleName();
    private final static int LENGTH = 0;
    private final static int WIDTH = 1;
    private final static int HEIGHT = 2;
    public List<int[]> intArrays;
    private String[] tokens;

    public Day2Area() {
        this.intArrays = new ArrayList<>();
    }

    public double getResult(String fileData) {
        tokenizeFileData(fileData);
        convertTokensToIntArrays();
        return findAreaPlusSmallDimension();
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

    public double findAreaPlusSmallDimension() {
        double totalSurfaceArea = 0;
        for (int[] intArr : intArrays) {
            double LxW = (2 * intArr[LENGTH] * intArr[WIDTH]);
            double WxH = (2 * intArr[WIDTH] * intArr[HEIGHT]);
            double HxL = (2 * intArr[HEIGHT] * intArr[LENGTH]);

            List<Integer> dimensions = new ArrayList<>();
            dimensions.add(intArr[LENGTH] * intArr[WIDTH]);
            dimensions.add(intArr[WIDTH] * intArr[HEIGHT]);
            dimensions.add(intArr[HEIGHT] * intArr[LENGTH]);
            Collections.sort(dimensions);

            double surfaceArea = LxW + WxH + HxL;
            double smallestDimension = dimensions.get(0);
            totalSurfaceArea += surfaceArea + smallestDimension;
        }
        return totalSurfaceArea;
    }

    public void extraAppend(StringBuilder txt) {
        txt.append("x");
    }
}