package com.epam.mentoring.task1;

public class Circle implements Shape {

    private final Double radius;
    
    public Circle(Double radius) {
        this.radius = radius < 0 ? 0 : radius;
    }

    @Override
    public Double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}
