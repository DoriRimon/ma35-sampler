package base.types.labTest.corona;

import base.types.labTest.LabTest;

public class LabTestCorona extends LabTest {
    private int resultTestCorona;
    private String variant;
    private String testType;
    private String joinDate;
    private int healthCareId;
    private String healthCareName;

    public LabTestCorona(int idNum, int idType, String firstName, String lastName,
                         String resultDate, String birthDate, String labCode, String stickerNumber,
                         int resultTestCorona, String variant, String testType,
                         String joinDate, int healthCareId, String healthCareName) {
        super(idNum, idType, firstName, lastName, resultDate, birthDate, labCode, stickerNumber);
        this.resultTestCorona = resultTestCorona;
        this.variant = variant;
        this.testType = testType;
        this.joinDate = joinDate;
        this.healthCareId = healthCareId;
        this.healthCareName = healthCareName;
    }

    public int getResultTestCorona() {
        return resultTestCorona;
    }

    public void setResultTestCorona(int resultTestCorona) {
        this.resultTestCorona = resultTestCorona;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public int getHealthCareId() {
        return healthCareId;
    }

    public void setHealthCareId(int healthCareId) {
        this.healthCareId = healthCareId;
    }

    public String getHealthCareName() {
        return healthCareName;
    }

    public void setHealthCareName(String healthCareName) {
        this.healthCareName = healthCareName;
    }
}
