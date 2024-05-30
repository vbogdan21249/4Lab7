package loader;

import builders.Builder;
import builders.CircularBuilder;
import builders.RectangularBuilder;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * A class for loading play space configuration from a file.
 */
public class ConfigurationLoader {

    private final String filePath;

    /**
     * Constructs a ConfigurationLoader with the given file path.
     *
     * @param filePath The path to the configuration file.
     */
    public ConfigurationLoader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads play space configurations from the file.
     *
     * @return A list of builders representing the loaded play space configurations.
     */
    public List<Builder> loadPlaySpaceConfig() {
        List<Builder> builders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String playSpaceType = null;
            int width = 0;
            int height = 0;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key) {
                        case "playSpaceType" -> playSpaceType = value;
                        case "width" -> width = Integer.parseInt(value);
                        case "height" -> height = Integer.parseInt(value);
                    }

                    if (playSpaceType != null && width > 0 && height > 0) {
                        Builder builder;
                        switch (playSpaceType) {
                            case "rectangular":
                                builder = new RectangularBuilder();
                                break;
                            case "circular":
                                builder = new CircularBuilder();
                                break;
                            default:
                                System.err.println("Unknown play space type: " + playSpaceType);
                                continue;
                        }

                        builder.setWidth(width);
                        builder.setHeight(height);
                        builders.add(builder);

                        playSpaceType = null;
                        width = 0;
                        height = 0;
                    }
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return builders;
    }
}