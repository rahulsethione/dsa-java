package inheritence;

public class SUV extends Car {

    // Own field for hiding same name and type field in base class
    private String color;

    private boolean is4x4;

    public final static String VEHICLE_TYPE = "SUV";

    public static String getVehicleType() {
        return VEHICLE_TYPE;
    }

    public static int getDefaultSeatingCapacity() {
        return 7;
    }

    public SUV(int makeYear, String brand, String modelName, int revision, int seatingCapacity, String color) {
        super(makeYear, brand, modelName, revision, seatingCapacity, color);
    }

//    @Override
//    public int getSeatingCapacity() {
//        return seatingCapacity;
//    }

//    @Override
//    public void setSeatingCapacity(int seatingCapacity) {
//        this.seatingCapacity = seatingCapacity;
//    }

    public boolean isIs4x4() {
        return is4x4;
    }

    public void setIs4x4(boolean is4x4) {
        this.is4x4 = is4x4;
    }

    @Override
    public String getColor() {
        printDetails();
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public String getBaseColor() {
        return super.getColor();
    }

    private void printDetails() {
        System.out.println("Overridden");
    }
}
