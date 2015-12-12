package com.emersonjason.puzzle1.PuzzleSolutions;

public class Point {
    private final static String TAG = Point.class.getSimpleName();
    private int xAxis;
    private int yAxis;

    public Point(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (xAxis != point.xAxis) return false;
        return yAxis == point.yAxis;
    }

    @Override
    public int hashCode() {
        int result = xAxis;
        result = 31 * result + yAxis;
        return result;
    }

    public String getPoint() {
        String x = Integer.toString(xAxis);
        String y = Integer.toString(yAxis);
        return x + " " + y;
    }
}
