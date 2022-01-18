package base.types.isolated;

import base.types.labTest.LabTest;
import base.types.madaReport.MadaReport;

public class IsolatedUtils {
    public static Isolated joinMadaReportAndLabTest(MadaReport madaReport, LabTest labTest) {
        int idNum = madaReport.getIdNum();
        int idType = madaReport.getIdType();
        String firstName = madaReport.getFirstName();
        String lastName = madaReport.getLastName();
        String city = madaReport.getCity();
        String street = madaReport.getStreet();
        int buildingNumber = madaReport.getBuildingNumber();
        String barcode = madaReport.getBarcode();
        String birthDate = labTest.getBirthDate();
        String labCode = labTest.getLabCode();
        String resultDate = labTest.getResultDate();
        String takeDate = madaReport.getTakeDate();
        String stickerNumber = labTest.getStickerNumber();
        int resultTestCorona = labTest.getResultTestCorona();
        String variant = labTest.getVariant();
        String testType = labTest.getTestType();

        Isolated isolated = new Isolated(idNum, idType, firstName, lastName, city, street, buildingNumber,
                barcode, birthDate, labCode, resultDate, takeDate, stickerNumber, resultTestCorona,
                variant, testType);
        return isolated;
    }
}
