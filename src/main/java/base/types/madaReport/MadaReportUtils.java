package base.types.madaReport;

import org.apache.commons.csv.CSVRecord;

/**
 * The MadaReportUtils class provides utils for the MadaReport class
 */
public class MadaReportUtils {
    /**
     * Transforms a csv record in the form of [MDACODE,IDNum,IDType,FirstName,LastName,City,Street,
     * BuildingNumber,Barcode,GetDate,TakeDate,ResultDate] to a MadaReport object
     * @param record - the record to be transformed
     * @return The MadaReport representation of the record
     */
    public static MadaReport recordToMadaReport(CSVRecord record) {
        String madaCode = record.get(0);
        int idNum = Integer.parseInt(record.get(1));
        int idType = Integer.parseInt(record.get(2));
        String firstName = record.get(3);
        String lastName = record.get(4);
        String city = record.get(5);
        String street = record.get(6);
        int buildingNumber = Integer.parseInt(record.get(7));
        String barcode = record.get(8);
        String getDate = record.get(9);
        String takeDate = record.get(10);
        String resultDate = record.get(11);

        MadaReport madaReport = new MadaReport(madaCode, idNum, idType, firstName, lastName,
                city, street, buildingNumber, barcode, getDate, takeDate, resultDate);
        return madaReport;
    }
}
