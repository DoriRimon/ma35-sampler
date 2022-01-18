package base.types.labTest.serology;

import org.apache.commons.csv.CSVRecord;


/**
 * Provides utils for the LabTestSerology class
 */
public class LabTestSerologyUtils {
    /**
     * Transforms a csv record in the form of [IDNum,IDType,FirstName,LastName,ResultDate,
     * BirthDate,LabCode,StickerNumber,Antidotes,KitNumber] to a LabTestSerology object
     * @param record - the record to be transformed
     * @return The LabTestSerology representation of the record
     */
    public static LabTestSerology recordToLabTestCorona(CSVRecord record) {
        int idNum = Integer.parseInt(record.get(0));
        int idType = Integer.parseInt(record.get(1));
        String firstName = record.get(2);
        String lastName = record.get(3);
        String resultDate = record.get(4);
        String birthDate = record.get(5);
        String labCode = record.get(6);
        String stickerNumber = record.get(7);
        int antidotes = Integer.parseInt(record.get(8));
        int kitNumber = Integer.parseInt(record.get(9));

        return new LabTestSerology(idNum, idType, firstName, lastName, resultDate, birthDate, labCode,
                stickerNumber, antidotes, kitNumber);
    }
}
