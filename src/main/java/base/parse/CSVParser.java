package base.parse;

import base.config.Configurations;
import org.apache.commons.csv.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * The CSVParser parses a CSV file
 */
public class CSVParser implements Parser<CSVRecord> {
    private Configurations configurations;
    private org.apache.commons.csv.CSVParser parser;

    /**
     * Initializes CSV file to given file path
     * @param filePathKey - The key of the file path in the config file
     * @throws IOException - If the reading of the file failed
     */
    public CSVParser(String filePathKey) throws IOException {
        this.configurations = new Configurations();
        this.parser = new org.apache.commons.csv.CSVParser(new FileReader(this.configurations.get(filePathKey)), CSVFormat.RFC4180);
    }

    /**
     * Gets all the record in the file
     * @return - A list of all CSVRecords in the file, or null if parsing failed
     */
    @Override
    public List<CSVRecord> getRecords() {
        try {
            return this.parser.getRecords();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
