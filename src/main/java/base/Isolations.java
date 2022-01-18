package base;

import base.types.isolated.Isolated;
import base.types.isolated.IsolatedUtils;
import base.types.labTest.corona.LabTestCorona;
import base.types.madaReport.MadaReport;
import base.write.JsonWriter;
import base.write.WriteType;
import base.write.Writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The main class for Sampler - Stage C
 */
public class Isolations {
    private MadaReports madaReports;
    private LabTestsCorona labTests;
    private Writer<Isolated> writer;

    public Isolations() {
        this.madaReports = new MadaReports();
        this.labTests = new LabTestsCorona();

        try {
            this.writer = new JsonWriter<>("jsonDirPath", WriteType.FILE_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Streams data from relevant CSV files to jsons
     */
    public void streamData() {
        /* Create Map { id number -> mada report } */
        HashMap<Integer, MadaReport> idToMadaReport = new HashMap<>();
        List<MadaReport> madaReports = this.madaReports.getMadaReports();
        madaReports.forEach(madaReport -> idToMadaReport.put(madaReport.getIdNum(), madaReport));

        List<Isolated> isolates = new ArrayList<>();

        /* Filter labTests to those that have corona, Join madaReports and labTests on idNum */
        List<LabTestCorona> labTests = this.labTests.getLabTestsCorona();
        labTests.stream().filter(labTest -> labTest.getResultTestCorona() == 1).forEach(labTest -> {
            MadaReport correspondingMadaReport = idToMadaReport.get(labTest.getIdNum());
            Isolated isolated = IsolatedUtils.joinMadaReportAndLabTest(correspondingMadaReport, labTest);
            isolates.add(isolated);
        });

        /* Write isolates to files */
        isolates.forEach(isolated -> {
            try {
                this.writer.write(isolated);
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
