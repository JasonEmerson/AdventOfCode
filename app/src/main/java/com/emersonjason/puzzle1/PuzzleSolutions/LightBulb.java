package com.emersonjason.puzzle1.PuzzleSolutions;

public class LightBulb {
    private boolean isOn = false;

    public void switchLight(String state) {
        switch (state) {
            case "toggle": {
                if (isOn) {
                    isOn = false;
                } else {
                    isOn = true;
                }
                break;
            }
            case "on": isOn = true;
                break;
            case "off": isOn = false;
                break;
        }
    }

    public boolean getStatus() {
        return isOn;
    }
}
