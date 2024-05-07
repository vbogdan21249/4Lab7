package main;

import builders.*;
import director.Director;
import loader.ConfigurationLoader;
import java.util.List;

/**
 * The main class for testing the play space construction.
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();

//        Builder rectangularBuilder = new RectangularBuilder();
//        director.constructRectangularPlaySpace(rectangularBuilder, 100, 200);
//        rectangularBuilder.build();
//
//        Builder circularBuilder = new CircularBuilder();
//        director.constructCircularPlaySpace(circularBuilder, 50);
//        circularBuilder.build();

        ConfigurationLoader loader = new ConfigurationLoader("src/main/resources/config.txt");
        List<Builder> builders = loader.loadPlaySpaceConfig();
        for (Builder b : builders) {
            try {
                b.build();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}