package com.emersonjason.puzzle1.PuzzleSolutions;

import android.util.Log;
import com.emersonjason.puzzle1.PuzzleAlgorithm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3GridPartTwo implements PuzzleAlgorithm {
    private final static String TAG = Day3Grid.class.getSimpleName();
    private char[] tokens;
    private List<Character> santa;
    private List<Character> santaRobot;
    private List<Point> totalHouses;

    public Day3GridPartTwo() {
        santa = new ArrayList<>();
        santaRobot = new ArrayList<>();
        totalHouses = new ArrayList<>();
    }

    public double getResult(String fileData) {
        tokenizeFileData(fileData);
        splitArray();
        findHousesDeliveredTo(santa);
        findHousesDeliveredTo(santaRobot);
        return findTotalHousesDeliveredTo();
    }

    public void tokenizeFileData(String fileData) {
        tokens = fileData.toCharArray();
        Log.v(TAG, String.valueOf(tokens.length));
    }

    public void splitArray() {
        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) {
                santa.add(tokens[i]);
            } else {
                santaRobot.add(tokens[i]);
            }
        }
    }

    public void findHousesDeliveredTo(List<Character> list) {
        List<Point> houses = new ArrayList<>();
        houses.add(new Point(0, 0));
        int xAxis = 0;
        int yAxis = 0;
        for (char direction : list) {
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
        totalHouses.addAll(houses);
    }

    public double findTotalHousesDeliveredTo() {
        Set<Point> noDuplicateHouses = new HashSet<>(totalHouses);
        totalHouses.clear();
        totalHouses.addAll(noDuplicateHouses);
        return totalHouses.size();
    }

    public void extraAppend(StringBuilder txt) {
    }
}
