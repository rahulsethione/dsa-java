package datatypes;

import java.util.function.Consumer;

public class Primitives {
    public static void main(String[] args) {

        Consumer<Object> log = printable -> System.out.println(printable);

        // Numeric
        int n = 10;
        float pi = 3.14f;
        double e = 2.3e10;
        long population = 9999999900l;
        long count = 100;
        short size = 32767;
        byte data = -128;

        // String and Character
        char a = 'A';
        String str = "string"; // Object (non-primitive), immutable, non-extensible

        // String pooling
        String lang = "Java";
        String langObj = new String("Java");
        System.out.println(lang == "Java"); // true
        System.out.println(lang == langObj); // false
        System.out.println(langObj == new String("Java")); // false
        System.out.println(lang.equals(langObj)); // true
        System.out.println(lang == langObj.intern()); // true

        // Type compatibility, type casting and interoperability
        int radius = 5;
        float circumference = 2 * radius * pi;
        System.out.println(circumference);

        int newborns = 15;
        population += newborns;
        System.out.println(population);

        int dist = 7, time = 2;
        int speed = dist / time;
        float speedFloat = dist / time; // 3.0 (Not 3.5)
        long speedLong = dist / time;
        System.out.println(speed);
        System.out.println(speedFloat);
        System.out.println(speedLong);

        double maxDist = 17.45;
        // int speedInt = maxDist / time; // Compilation error
        int speedInt = (int) (maxDist / time); // 8 (Not 8.725)
        double speedDouble = maxDist / time;
        System.out.println(speedInt);
        System.out.println(speedDouble);

    }
}
