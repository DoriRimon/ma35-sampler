package base;

import base.parse.CSVParser;
import base.parse.Parser;
import base.types.labTest.corona.LabTestCorona;
import base.types.labTest.corona.LabTestCoronaUtils;
import base.write.Writer;
import base.write.XmlWriter;
import health_care_provider.errors.InvalidIdException;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * The main class for Sampler - Stage B
 */
public class LabTestsCorona {
    private Parser<CSVRecord> parser;
    private Writer<LabTestCorona> writer;

    public LabTestsCorona() {
        try {
            this.parser = new CSVParser("labTestsCsvFilePath");
            this.writer = new XmlWriter<>("xmlDirPath", "labTests", "labTest");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all the labTests from relevant CSV file
     * @return List of all LabTests
     */
    public List<LabTestCorona> getLabTestsCorona() {
        List<CSVRecord> records = this.parser.getRecords();
        records.remove(0); /* remove first row - columns names */

        /* Map record to LabTest object, and remove those with invalid Ids */
        return records.stream().map(record -> {
            try {
                return LabTestCoronaUtils.recordToLabTestCorona(record);
            } catch (InvalidIdException e) {
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * Streams data from the csv file to xml files
     */
    public void streamData() {
        /* Map record to LabTest object, and remove those with invalid Ids */
        getLabTestsCorona().forEach(labTest -> {
            try {
                this.writer.write(labTest);
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
