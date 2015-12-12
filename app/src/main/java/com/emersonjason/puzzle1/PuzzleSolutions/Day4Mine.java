package com.emersonjason.puzzle1.PuzzleSolutions;

import android.util.Log;

import com.emersonjason.puzzle1.IntArrayBuilder;
import com.emersonjason.puzzle1.PuzzleAlgorithm;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day4Mine implements PuzzleAlgorithm {
    private final static String TAG = Day4Mine.class.getSimpleName();
    private String fileData;

    public Day4Mine() {

    }

    public double getResult(String fileData) {
        this.fileData = fileData;
        findLowestPositiveNumber();
        return 0;
    }

    public void findLowestPositiveNumber() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "NoSuchAlgorithmException");
        }
        try {
            byte[] bytesOfMessage = fileData.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "NoSuchAlgorithmException");
        }

        //byte[] thedigest = md.digest(bytesOfMessage);

    }

    public void extraAppend(StringBuilder txt) {
    }
}