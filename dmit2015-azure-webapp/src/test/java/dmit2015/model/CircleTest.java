package dmit2015.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void area_SmallValue_ReturnsCorrectResult() {
        // Arrange and Act
        Circle circle1 = new Circle(5);
        // Assert
        assertEquals(78.54, circle1.area(), 0.005);
    }

    @Test
    void diameter_SmallValue_ReturnsCorrectResult() {
        // Arrange and Act
        Circle circle1 = new Circle(5);
        // Assert
        assertEquals(10, circle1.diameter());
    }

    @Test
    void circumference_SmallValue_ReturnsCorrectResult() {
        // Arrange and Act
        Circle circle1 = new Circle(5);
        // Assert
        assertEquals(31.42, circle1.circumference(), 0.005);
    }

    @Test
    void allMethods_SmallValue_ReturnsCorrectResult() {
        // Arrange and Act
        Circle circle1 = new Circle(5);
        // Assert
        assertAll("all methods",
                () -> assertEquals(78.54, circle1.area(), 0.01),
                () -> assertEquals(10, circle1.diameter()),
                () -> assertEquals(31.42, circle1.circumference(), 0.005)
        );
    }

    @Test
    void setRadius_InvalidRadius_ThrowsRuntimeException() {
        // Arrange
        Circle circle1 = new Circle();
        // Act
        var exception = assertThrows(
                RuntimeException.class,
                () -> circle1.setRadius(-10));
        // Assert
        assertEquals("Radius must be a positive non-zero number.", exception.getMessage());
    }

    @ParameterizedTest(name = "radius = {0}, expected area = {1}")
    @CsvSource({
            "1.0, 3.14",
            "25.0, 1963.50",
            "100.0, 31415.93",
            "125.0, 49087.39",
    })
    void area_DifferentRadius_ReturnsCorrectResults(double radius, double expectedArea) {
        // Arrange
        Circle circle1 = new Circle();
        // Act
        circle1.setRadius(radius);
        // Assert
        assertEquals(expectedArea, circle1.area(), 0.005);
    }

    @ParameterizedTest(name = "radius = {0}, expected diameter = {1} ")
    @CsvSource({
            "1.0, 2.0",
            "25.0, 50.0",
            "100.0, 200.0",
            "125.0, 250.0",
    })
    void diameter_DifferentRadius_ReturnsCorrectResults(double radius, double expectedDiameter) {
        // Arrange
        Circle circle1 = new Circle();
        // Act
        circle1.setRadius(radius);
        // Assert
        assertEquals(expectedDiameter, circle1.diameter(), 0.05);
    }

    @ParameterizedTest(name = "radius = {0}, expected circumference = {1} ")
    @CsvSource({
            "1.0, 6.28",
            "25.0, 157.08",
            "100.0, 628.32",
            "125.0, 785.40",
    })
    void circumference_DifferentRadius_ReturnsCorrectResults(double radius, double
            expectedCircumference) {
        // Arrange
        Circle circle1 = new Circle();
        // Act
        circle1.setRadius(radius);
        // Assert
        assertEquals(expectedCircumference, circle1.circumference(), 0.005);
    }
}