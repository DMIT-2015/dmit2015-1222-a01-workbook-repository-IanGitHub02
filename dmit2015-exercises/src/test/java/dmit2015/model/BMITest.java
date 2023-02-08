package dmit2015.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BMITest {
    @ParameterizedTest(name = "weight = {0}, height = {1}, expected bmi = {2}")
    @CsvSource({
            "100, 66, 16.1",
            "140, 66, 22.6",
            "175, 66, 28.2",
            "200, 66, 32.3",
    })

    void bmi_DifferentWeightAndHeight_ReturnsCorrectBMIs(int weight, int height, double expectedBMI) {
        // Arrange
        BMI bmi1 = new BMI();
        // Act
        bmi1.setWeight(weight);
        bmi1.setHeight(height);
        // Assert
        assertEquals(expectedBMI, bmi1.bmi(), 0.05);
    }

    @ParameterizedTest(name = "weight = {0}, height = {1}, expected bmi = {2}")
    @CsvSource({
            "100, 66, underweight",
            "140, 66, normal",
            "175, 66, overweight",
            "200, 66, obese",
    })

    void bmiCategory_DifferentWeightAndHeight_ReturnsCorrectCategories(int weight, int height, String expectedCategory) {
        // Arrange
        BMI bmi1 = new BMI();
        // Act
        bmi1.setWeight(weight);
        bmi1.setHeight(height);
        // Assert
        assertEquals(expectedCategory, bmi1.bmiCategory());
    }
}