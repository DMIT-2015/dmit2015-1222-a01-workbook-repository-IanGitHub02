package dmit2015.model;

import lombok.Data;

@Data
public class BMI {
    private int weight;
    private int height;

    public double bmi() {
        return ((double) 703 * weight) / Math.pow(height, 2);
    }

    public String bmiCategory() {
        if (bmi() < 18.5) {
            return "underweight";
        }
        else if (bmi() >= 18.5 && bmi() < 25.0) {
            return "normal";
        }
        else if (bmi() >= (double) 25 && bmi() < (double) 30) {
            return "overweight";
        }
        else {
            return "obese";
        }
    }
}
