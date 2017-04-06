package com.epam.mentoring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

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

        assertThat(circle1.getArea()).isEqualTo(Math.PI * 4);
        assertThat(circle2.getArea()).isEqualTo(Math.PI * 9);
        assertThat(circle3.getArea()).isEqualTo(0.0);
    }
    
    @Test
    public void areaOfRectangle() {
        Shape rectangle1 = new Rectangle(1.0, 1.0);
        Shape rectangle2 = new Rectangle(2.0, 3.0);
        Shape rectangle3 = new Rectangle(-1.0, 1.0);
        Shape rectangle4 = new Rectangle(1.0, -1.0);

        assertThat(rectangle1.getArea()).isEqualTo(1.0);
        assertThat(rectangle2.getArea()).isEqualTo(6.0);
        assertThat(rectangle3.getArea()).isEqualTo(0.0);
        assertThat(rectangle4.getArea()).isEqualTo(0.0);
    }
    
    @Test
    public void areaOfRightTriangle() {
        Shape triangle1 = new RightTriangle(1.0, 1.0);
        Shape triangle2 = new RightTriangle(2.0, 3.0);
        Shape triangle3 = new RightTriangle(-1.0, 1.0);
        Shape triangle4 = new RightTriangle(1.0, -1.0);

        assertThat(triangle1.getArea()).isEqualTo(0.5);
        assertThat(triangle2.getArea()).isEqualTo(3.0);
        assertThat(triangle3.getArea()).isEqualTo(0.0);
        assertThat(triangle4.getArea()).isEqualTo(0.0);
    }
    
}
