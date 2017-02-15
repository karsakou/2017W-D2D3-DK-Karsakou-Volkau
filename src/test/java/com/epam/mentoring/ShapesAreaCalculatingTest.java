package com.epam.mentoring;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.epam.mentoring.task1.Circle;
import com.epam.mentoring.task1.Rectangle;
import com.epam.mentoring.task1.RightTriangle;
import com.epam.mentoring.task1.Shape;

public class ShapesAreaCalculatingTest {

    @Test
    public void areaOfCircle() {
        Shape circle1 = new Circle(2.0);
        Shape circle2 = new Circle(3.0);
        Shape circle3 = new Circle(-2.0);

        assertEquals(circle1.getArea(), Math.PI * 4);
        assertEquals(circle2.getArea(), Math.PI * 9);
        assertEquals(circle3.getArea(), 0.0);
    }
    
    @Test
    public void areaOfRectangle() {
        Shape rectangle1 = new Rectangle(1.0, 1.0);
        Shape rectangle2 = new Rectangle(2.0, 3.0);
        Shape rectangle3 = new Rectangle(-1.0, 1.0);
        Shape rectangle4 = new Rectangle(1.0, -1.0);

        assertEquals(rectangle1.getArea(), 1.0);
        assertEquals(rectangle2.getArea(), 6.0);
        assertEquals(rectangle3.getArea(), 0.0);
        assertEquals(rectangle4.getArea(), 0.0);
    }
    
    @Test
    public void areaOfRightTriangle() {
        Shape triangle1 = new RightTriangle(1.0, 1.0);
        Shape triangle2 = new RightTriangle(2.0, 3.0);
        Shape triangle3 = new RightTriangle(-1.0, 1.0);
        Shape triangle4 = new RightTriangle(1.0, -1.0);

        assertEquals(triangle1.getArea(), 0.5);
        assertEquals(triangle2.getArea(), 3.0);
        assertEquals(triangle3.getArea(), 0.0);
        assertEquals(triangle4.getArea(), 0.0);
    }
    
}
