package dmit2015.model;

import lombok.Getter;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;

public class CanadianIncomeTaxManager {
    // Define a private constructor to implement Single pattern
    private CanadianIncomeTaxManager(){

    }

    // Define a single instance of this class
    private static CanadianIncomeTaxManager INSTANCE;

    // Define a static class-level to access the singleton
    public static CanadianIncomeTaxManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CanadianIncomeTaxManager();
        }

        return INSTANCE;
    }

    @Getter
    private List<CanadianPersonalIncomeTaxRate> incomeTaxRates;

    public void loadDataFromFile() {
        try {
            Path csvPath = Path.of(getClass().getClassLoader().getResource("data/CanadianPersonalIncomeTaxRates.csv").toURI());

            // Use the following code to access a resource file not stored in your project
            // Path csvPath = Path.of("d:/temp/electricity-exports-and-imports-data-dictionary.csv");

            // Use the `Files.readAllLines()` method to read all lines from a file as a List.
            System.out.println("I am reading all the lines from the csv file into a list of String.");

            //incomeTaxRates = Files.readAllLines(csvPath);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
