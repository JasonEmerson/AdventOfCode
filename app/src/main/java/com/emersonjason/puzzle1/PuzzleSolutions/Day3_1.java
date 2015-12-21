package com.emersonjason.puzzle1.PuzzleSolutions;

import com.emersonjason.puzzle1.PuzzleAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3_1 implements PuzzleAlgorithm {
    private final static String TAG = Day3_1.class.getSimpleName();
    private char[] tokens;

    public double getResult(String fileData) {
        tokenizeFileData(fileData);
        return findHousesDeliveredTo();
    }

    public void tokenizeFileData(String fileData) {
        tokens = fileData.toCharArray();
    }

    public double findHousesDeliveredTo() {
        List<Point> houses = new ArrayList<>();
        houses.add(new Point(0, 0));
        int xAxis = 0;
        int yAxis = 0;
        for (char direction : tokens) {
            switch (direction) {
                case '^':
                    yAxis++;
                    break;
                case 'v':
                    yAxis--;
                    break;
                case '>':
                    xAxis++;
                    break;
                case '<':
                    xAxis--;
                    break;
            }
            houses.add(new Point(xAxis, yAxis));
        }
        Set<Point> noDuplicateHouses = new HashSet<>(houses);
        houses.clear();
        houses.addAll(noDuplicateHouses);
        return houses.size();
    }

    public void extraAppend(StringBuilder txt) {
    }
}
