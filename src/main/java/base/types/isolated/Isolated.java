package base.types.isolated;

/**
 * Represents an isolated person
 */
public class Isolated {
    private int idNum;
    private int idType;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private int buildingNumber;
    private String barcode;
    private String birthDate;
    private String labCode;
    private String resultDate;
    private String takeDate;
    private String stickerNumber;
    private int resultTestCorona;
    private String variant;
    private String testType;

    public Isolated(int idNum, int idType, String firstName, String lastName, String city, String street, int buildingNumber, String barcode, String birthDate, String labCode, String resultDate, String takeDate, String stickerNumber, int resultTestCorona, String variant, String testType) {
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.barcode = barcode;
        this.birthDate = birthDate;
        this.labCode = labCode;
        this.resultDate = resultDate;
        this.takeDate = takeDate;
        this.stickerNumber = stickerNumber;
        this.resultTestCorona = resultTestCorona;
        this.variant = variant;
        this.testType = testType;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public String getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(String takeDate) {
        this.takeDate = takeDate;
    }

    public String getStickerNumber() {
        return stickerNumber;
    }

    public void setStickerNumber(String stickerNumber) {
        this.stickerNumber = stickerNumber;
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
}
