package inheritence;

public class Test {
    public static void main(String[] args) {
        Car hyundaiTucson = new Car(2022, "Hyundai", "Tucson", 1, 5, "Red");
        SUV hyundaiPalisade = new SUV(2021, "Hyundai", "Palisade", 1, 5, "Black");
        SUV toyotaHarrier = new SUV(2022, "Toyota", "Harrier", 1, 5, "White");
        Car hondaCRV = new SUV(2021, "Honda", "CRV", 2, 5, "Silver");

        hyundaiPalisade.setColor("Grey");
        // toyotaHarrier.setColor("Navy");
        hondaCRV.setColor("Blue");

        System.out.println("hyundaiTucson.getSeatingCapacity() = " + hyundaiTucson.getSeatingCapacity());
        System.out.println("hyundaiPalisade.getSeatingCapacity() = " + hyundaiPalisade.getSeatingCapacity());
        System.out.println("hyundaiPalisade.getColor() = " + hyundaiPalisade.getColor());
        System.out.println("toyotaHarrier.getColor() = " + toyotaHarrier.getColor());
        System.out.println("toyotaHarrier.getBaseColor() = super.getColor() = " + toyotaHarrier.getBaseColor());
        System.out.println("hondaCRV.getColor() = " + hondaCRV.getColor());

        System.out.println("Car.getVehicleType() = " + Car.getVehicleType());
        System.out.println("SUV.getVehicleType() = " + SUV.getVehicleType());

        System.out.println("Car.getVehicleType() = " + Car.getDefaultSeatingCapacity());
        System.out.println("SUV.getVehicleType() = " + SUV.getDefaultSeatingCapacity());
    }
}
