package base;

import base.parse.CSVParser;
import base.parse.Parser;
import base.types.madaReport.MadaReport;
import base.write.JsonWriter;
import base.write.Writer;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

/**
 * The main class for Sampler - Stage A
 */
public class MadaReports {
    private Parser<CSVRecord> parser;
    private Writer<MadaReport> writer;

    public MadaReports() {
        try {
            this.parser = new CSVParser("csvFilePath");
            this.writer = new JsonWriter<>("jsonDirPath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Streams data from the csv file to json files
     */
    public void streamData() {

    }
}
