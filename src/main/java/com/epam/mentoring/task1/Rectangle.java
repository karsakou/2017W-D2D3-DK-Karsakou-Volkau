package com.epam.mentoring.task1;

public class Rectangle implements Shape {

    private final Double width;
    
    private final Double height;

    public Rectangle(Double width, Double height) {
        this.width = width < 0 ? 0 : width;
        this.height = height < 0 ? 0 : height;
    }

    @Override
    public Double getArea() {
        return height * width;
    }
    
}
