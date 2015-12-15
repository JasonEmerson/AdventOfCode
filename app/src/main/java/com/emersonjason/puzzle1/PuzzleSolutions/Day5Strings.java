package com.emersonjason.puzzle1.PuzzleSolutions;

import android.util.Log;

import com.emersonjason.puzzle1.PuzzleAlgorithm;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class Day5Strings implements PuzzleAlgorithm {
    private final static String TAG = Day5Strings.class.getSimpleName();
    List<String> disqualifiers;
    private String[] words;

    public Day5Strings() {
        this.disqualifiers = new ArrayList<>();
        disqualifiers.add("ab");
        disqualifiers.add("cd");
        disqualifiers.add("pq");
        disqualifiers.add("xy");
    }

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
            if (checkQualification(word) && checkForTwoInRow(word) &&
                    checkForThreeVowels(word))
                correctWords++;
        }
        return correctWords;
    }

    public boolean checkQualification(String word) {
        StringCharacterIterator iterator = new StringCharacterIterator(word);
        boolean isQualified = true;

        for (int i = 0; i < word.length() - 1; i++) {
            char previous = iterator.current();
            iterator.next();
            char current = iterator.current();
            String checkChars = String.valueOf(previous) + String.valueOf(current);
            for (String s : disqualifiers) {
                if (s.equals(checkChars)) {
                    isQualified = false;
                }
            }
        }
        return isQualified;
    }

    public boolean checkForThreeVowels(String word) {
        int vowelCount = 0;

        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelCount++;
                    break;
            }
        }
        return (vowelCount > 2);
    }

    public boolean checkForTwoInRow(String word) {
        StringCharacterIterator iterator = new StringCharacterIterator(word);
        boolean hasTwoInRow = false;

        for (int i = 0; i < word.length() - 1; i++) {
            char previous = iterator.current();
            iterator.next();
            if (previous == iterator.current()) {
                hasTwoInRow = true;
            }
        }
        return hasTwoInRow;
    }

    public void extraAppend(StringBuilder txt) {
        txt.append('-');
    }
}