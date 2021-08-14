package classes;

public class AnotherKlass {
    {
        a = 100;
        b = 200;
    }

    static int a = 10;
    int b = 20;

    static {
        a = 50;
    }

    public AnotherKlass() {
        b = 0;
    }

    void calc() {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        AnotherKlass anotherKlass = new AnotherKlass();

        anotherKlass.calc();
    }
}
