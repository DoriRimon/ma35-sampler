package base.types.madaReport;

/**
 * Represents a mada report record
 */
public class MadaReport {
    private String madaCode;
    private int idNum;
    private int idType;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private int buildingNumber;
    private String barcode;
    private String getDate;
    private String takeDate;
    private String resultDate;

    public MadaReport(String madaCode, int idNum, int idType, String firstName, String lastName, String city, String street, int buildingNumber, String barcode, String getDate, String takeDate, String resultDate) {
        this.madaCode = madaCode;
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.barcode = barcode;
        this.getDate = getDate;
        this.takeDate = takeDate;
        this.resultDate = resultDate;
    }

    public String getMadaCode() {
        return madaCode;
    }

    public void setMadaCode(String madaCode) {
        this.madaCode = madaCode;
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

    public String getGetDate() {
        return getDate;
    }

    public void setGetDate(String getDate) {
        this.getDate = getDate;
    }

    public String getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(String takeDate) {
        this.takeDate = takeDate;
    }

    public String getResultDate() {
        return resultDate;

    }
    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }
}
