package com.emersonjason.puzzle1.PuzzleSolutions;

import android.support.v4.util.ArrayMap;

import com.emersonjason.puzzle1.PuzzleAlgorithm;
import java.util.Map;

public class Day5_2 implements PuzzleAlgorithm {
    private final static String TAG = Day5_2.class.getSimpleName();
    private String[] words;

    public double getResult(String fileData) {
        tokenizeFileData(fileData);
        return checkWords(words);
    }

    public void tokenizeFileData(String fileData) {
        String delims = "[-]";
        words = fileData.split(delims);
    }

    public int checkWords(String[] words) {
        int correctWords = 0;
        for (String word : words) {
            if (checkForNonOverlappingPair(word) &&
                    checkForStaggered(word))
                correctWords++;
        }
        return correctWords;
    }

    public boolean checkForNonOverlappingPair(String word) {
        Map<Integer, String> list = new ArrayMap<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            list.put(i, String.valueOf(chars[i]) + String.valueOf(chars[i + 1]));
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j && i != j+1 && i != j-1) {
                    if (list.get(i).equals(list.get(j))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkForStaggered(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length() - 2; i++) {
            if (chars[i] == chars[i + 2]) {
                return true;
            }
        }
        return false;
    }

    public void extraAppend(StringBuilder txt) {
        txt.append('-');
    }
}