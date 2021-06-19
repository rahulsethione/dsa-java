package inheritence;

public class Car {
    private int makeYear;
    private String brand;
    private String modelName;
    private int revision;
    private int seatingCapacity;
    private String color;

    public final static String VEHICLE_TYPE = "Car";

    public static int getDefaultSeatingCapacity() {
        return 5;
    }

    public static String getVehicleType() {
        return VEHICLE_TYPE;
    }

    public Car(int makeYear, String brand, String modelName, int revision, int seatingCapacity, String color) {
        this.makeYear = makeYear;
        this.brand = brand;
        this.modelName = modelName;
        this.revision = revision;
        this.seatingCapacity = seatingCapacity;
        this.color = color;
    }

    public int getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(int makeYear) {
        this.makeYear = makeYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getColor() {
        printDetails();
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private void printDetails() {
        String details = "makeYear = " + makeYear + "/n"
            + "brand = " + brand + "/n";

        System.out.println(details);
    }
}
