public class Animal {
    private String code;
    private int ageYears;
    private int ageMonths;
    private int udders;
    private String type;

    public Animal(String code, int ageYears, int ageMonths, int udders, String type) {
        this.code = code;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.udders = udders;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public int getUdders() {
        return udders;
    }

    public String getType() {
        return type;
    }

    public void setUdders(int udders) {
        this.udders = udders;
    }
}