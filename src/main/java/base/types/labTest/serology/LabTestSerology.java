package base.types.labTest.serology;

import base.types.labTest.LabTest;


/**
 * Represents a serology lab test
 */
public class LabTestSerology extends LabTest {
    private int antidotes;
    private int kitNumber;

    public LabTestSerology(int idNum, int idType, String firstName, String lastName,
                           String resultDate, String birthDate, String labCode, String stickerNumber,
                           int antidotes, int kitNumber) {
        super(idNum, idType, firstName, lastName, resultDate, birthDate, labCode, stickerNumber);
        this.antidotes = antidotes;
        this.kitNumber = kitNumber;
    }

    public int getAntidotes() {
        return antidotes;
    }

    public void setAntidotes(int antidotes) {
        this.antidotes = antidotes;
    }

    public int getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(int kitNumber) {
        this.kitNumber = kitNumber;
    }
}
