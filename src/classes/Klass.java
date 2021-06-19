package classes;

public class Klass {

    Klass() {
        System.out.println("Default constructor");
    }

    {
        System.out.println("Initializer block");
    }

    static {
        System.out.println("Static block");
    }

    public static void main(String[] args) {
        System.out.println("Main method");
        Klass instance = new Klass();
    }
}
