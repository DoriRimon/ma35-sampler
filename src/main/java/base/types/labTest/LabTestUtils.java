package base.types.labTest;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;
import org.apache.commons.csv.CSVRecord;

/**
 * LabTestUtils class provides utils for the LabTest class
 */
public class LabTestUtils {
    /**
     * Transforms a csv record in the form of [IDNum,IDType,FirstName,LastName,ResultDate,
     * BirthDate,LabCode,StickerNumber,ResultTestCorona,Variant,TestType] to a LabTest object
     * @param record - the record to be transformed
     * @return The LabTest representation of the record
     */
    public static LabTest recordToLabTest(CSVRecord record) {
        int idNum = Integer.parseInt(record.get(0));
        int idType = Integer.parseInt(record.get(1));
        String firstName = record.get(2);
        String lastName = record.get(3);
        String resultDate = record.get(4);
        String birthDate = record.get(5);
        String labCode = record.get(6);
        String stickerNumber = record.get(7);
        int resultTestCorona = Integer.parseInt(record.get(8));
        String variant = record.get(9);
        String testType = record.get(10);

        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();
        String joinDate = null;
        int healthCareId = 0;
        String healthCareName = null;
        try {
            PersonInsured person = healthCareInfoProvider.fetchInfo(idNum, idType);
            joinDate = person.getJoinDate().toString();
            healthCareId = person.getHealthCareId();
            healthCareName = person.getHealthCareName();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }

        LabTest labTest = new LabTest(idNum, idType, firstName, lastName, resultDate, birthDate, labCode,
                stickerNumber, resultTestCorona, variant, testType, joinDate, healthCareId, healthCareName);
        return labTest;
    }
}
