package com.aptech.geometry;
public class Shapes {
    private Shapes() { }
    public static double circleArea(double r) { return Math.PI * r * r; }
    public static double rectangleArea(double w, double h) { return w * h; }
    public static double triangleArea(double base, double height) { return 0.5 * base * height; }
}
