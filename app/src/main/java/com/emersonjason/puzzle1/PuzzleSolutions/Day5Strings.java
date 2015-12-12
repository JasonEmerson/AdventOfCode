package com.emersonjason.puzzle1.PuzzleSolutions;

import com.emersonjason.puzzle1.IntArrayBuilder;
import com.emersonjason.puzzle1.PuzzleAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5Strings implements PuzzleAlgorithm {
    private final static String TAG = Day2Area.class.getSimpleName();
    public List<int[]> intArrays;
    private String[] tokens;

    public Day5Strings() {
        this.intArrays = new ArrayList<>();
    }

    public double getResult(String fileData) {
        tokenizeFileData(fileData);
        return 0;

    }

    public void tokenizeFileData(String fileData) {
        String delims = "[x]";
        tokens = fileData.split(delims);
    }

    public void extraAppend(StringBuilder txt) {}
}