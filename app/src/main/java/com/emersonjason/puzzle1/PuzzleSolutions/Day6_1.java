package com.emersonjason.puzzle1.PuzzleSolutions;


import com.emersonjason.puzzle1.PuzzleAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6_1 implements PuzzleAlgorithm {
    private static final String TAG = Day6_1.class.getSimpleName();
    List<List<LightBulb>> bulbGrid;
    private String[] words;

    public Day6_1() {
        this.bulbGrid = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            List<LightBulb> inner = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                inner.add(new LightBulb());
            }
            bulbGrid.add(inner);
        }
    }

    public double getResult(String fileData) {
        tokenizeFileData(fileData);
        operateLights();
        return lightCount();
    }

    public void operateLights() {
        for (String word : words) {
            operateSet(parseIntegersFromString(word),
                    parseStateFromString(word));
        }
    }

    public void tokenizeFileData(String fileData) {
        String delims = "[-]";
        words = fileData.split(delims);
    }

    public void operateSet(List<Integer> coords, String state) {
        for (int i = coords.get(0); i < coords.get(2)+1; i++) {
            for (int j = coords.get(1); j < coords.get(3)+1; j++) {
                bulbGrid.get(i).get(j).switchLight(state);
            }
        }
    }

    public List<Integer> parseIntegersFromString(String word) {
        List<Integer> coords = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]{1,3}");
        Matcher matcher = pattern.matcher(word);
        while(matcher.find()) {
            coords.add(Integer.parseInt(matcher.group()));
        }
        return coords;
    }

    public String parseStateFromString(String word) {
        String state = null;
        Pattern pattern = Pattern.compile("on|off|toggle");
        Matcher matcher = pattern.matcher(word);
        while(matcher.find()) {
            state = matcher.group();
        }
        return state;
    }

    public double lightCount() {
        int lightsOn = 0;
        for (List<LightBulb> inner : bulbGrid) {
            for (LightBulb bulb : inner) {
                if (bulb.getStatus())
                    lightsOn++;
            }
        }
        return lightsOn;
    }

    public void extraAppend(StringBuilder txt) {
        txt.append('-');
    }
}
