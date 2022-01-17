package base;

import base.parse.CSVParser;
import base.parse.Parser;
import base.types.labTest.LabTest;
import base.types.madaReport.MadaReport;
import base.types.madaReport.MadaReportUtils;
import base.write.JsonWriter;
import base.write.Writer;
import base.write.XmlWriter;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;


/**
 * The main class for Sampler - Stage B
 */
public class LabTests {
    private Parser<CSVRecord> parser;
    private Writer<LabTest> writer;

    public LabTests() {
        try {
            this.parser = new CSVParser("csvFilePath");
            this.writer = new XmlWriter<>("xmlDirPath", "labTests", "labTest");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
