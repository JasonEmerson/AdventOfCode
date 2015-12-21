package com.emersonjason.puzzle1;

import android.content.Context;
import android.util.Log;
import com.emersonjason.puzzle1.PuzzleSolutions.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Puzzle {
    private static final String TAG = Puzzle.class.getSimpleName();
    private Context context;
    private PuzzleAlgorithm puzzle;
    private String fileData;

    public Puzzle(Context context) {
        this.context = context;
        this.puzzle = new Day5_1();
    }

    public void solve() {
        loadRawStringFile();
        double result = puzzle.getResult(fileData);
        Log.v(TAG, "Result ------------------> " + result);
    }

    public void loadRawStringFile() {
        InputStream is = context.getResources().openRawResource(R.raw.day5input);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        StringBuilder txt = new StringBuilder();

        try {
            while ((line = br.readLine()) != null) {
                txt.append(line);
                puzzle.extraAppend(txt);
            }
        } catch (IOException e) {
            Log.e(TAG, "I/O failure");
        }
        fileData = txt.toString();
    }
}