package com.epam.mentoring.task1;

public class RightTriangle extends Rectangle {

    public RightTriangle(Double width, Double height) {
        super(width, height);
    }

    @Override
    public Double getArea() {
        return super.getArea() / 2;
    }

}
