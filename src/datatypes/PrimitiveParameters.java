package datatypes;

import java.util.Objects;

class IntegerRef {
    private int value;

    public IntegerRef(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerRef that = (IntegerRef) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

public class PrimitiveParameters {
    private static void log(Object printable) { System.out.println(printable); }

    public static void main(String[] args) {
        int x = 20;
        Integer y = 40;
        Integer z = new Integer(40);
        IntegerRef intRef = new IntegerRef(100);

        log("y == z: " + Boolean.valueOf(y == z)); // false

        log(callByValue(x)); // Value: 30
        log(x); // 20

        log(callByValue(y)); // 45
        log(y); // 40

        log(callByValue(z)); // 45
        log(z); // 40
    }

    static String callByValue(int num) {
        log("Primitive argument");
        num += 10;
        return "Value: " + num;
    }

    static String callByValue(Integer num) {
        log("Wrapper argument");
        num = new Integer(num + 5);
        return "Value: " + num;
    }

    static String callByReference(IntegerRef integerRef) {
        log("Call by reference");
        int value = integerRef.getValue() + 50;
        integerRef.setValue(value);
        return "Value: " + integerRef;
    }
}
