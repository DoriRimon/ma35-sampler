package base;

import base.parse.CSVParser;
import base.parse.Parser;
import base.types.madaReport.MadaReport;
import base.types.madaReport.MadaReportUtils;
import base.write.JsonWriter;
import base.write.Writer;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

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
        List<CSVRecord> records = this.parser.getRecords();
        records.remove(0); /* remove first row - columns names */
        records.stream().map(MadaReportUtils::recordToMadaReport).forEach(report -> {
            try {
                this.writer.write(report);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        try {
            this.writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
