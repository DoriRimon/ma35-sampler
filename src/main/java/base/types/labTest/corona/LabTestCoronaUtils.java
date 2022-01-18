package base.types.labTest.corona;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;
import org.apache.commons.csv.CSVRecord;


/**
 * Provides utils for the LabTestCorona class
 */
public class LabTestCoronaUtils {
    /**
     * Transforms a csv record in the form of [IDNum,IDType,FirstName,LastName,ResultDate,
     * BirthDate,LabCode,StickerNumber,ResultTestCorona,Variant,TestType] to a LabTestCorona object
     * @param record - the record to be transformed
     * @return The LabTestCorona representation of the record
     */
    public static LabTestCorona recordToLabTestCorona(CSVRecord record) throws InvalidIdException {
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
        PersonInsured person = healthCareInfoProvider.fetchInfo(idNum, idType);
        String joinDate = person.getJoinDate().toString();
        int healthCareId = person.getHealthCareId();
        String healthCareName = person.getHealthCareName();

        return new LabTestCorona(idNum, idType, firstName, lastName, resultDate, birthDate, labCode,
                stickerNumber, resultTestCorona, variant, testType, joinDate, healthCareId, healthCareName);
    }
}
