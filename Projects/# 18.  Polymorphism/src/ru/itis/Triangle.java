package ru.itis;

public class Triangle extends Shape implements PlaneFigure, Scalable {
    private double aSide;
    private double bSide;
    private double cSide;

    public Triangle(double x, double y, double aSide, double bSide, double cSide) {
        super(x, y);
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    public double getArea() {
        double perimeter = (aSide + bSide + cSide) / 2;
        return Math.sqrt(perimeter * (perimeter - aSide) * (perimeter - bSide) * (perimeter - cSide));
    }

    public double getASide() {
        return aSide;
    }

    public double getBSide() {
        return bSide;
    }

    public double getCSide() {
        return cSide;
    }

    public void scale(double value) {
        this.aSide = this.aSide * value;
        this.bSide = this.bSide * value;
        this.cSide = this.cSide * value;
    }
}
