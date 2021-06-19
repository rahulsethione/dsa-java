package classes;

import java.util.function.Consumer;

public interface MyTreeSet<T extends Comparable> {
    boolean add(T item);
}

class MyTreeMapImpl<T extends Comparable> implements MyTreeSet<T> {
    @Override
    public boolean add(T item) {
        return false;
    }
}

class LambdaTest {
    public int x = 1;
    class FirstLevel {
        public int x = 2;
        void methodInFirstLevel(int x) {
            int a = 7;
            Consumer<Integer> myConsumer = (y) -> {   // Lambda Expression
                System.out.println(x + a + "TEST");
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaTest.this.x = " + LambdaTest.this.x);
            };
            myConsumer.accept(x);
        }
    }
    public static void main(String args[]) {
        final LambdaTest outerClass = new LambdaTest();
        final LambdaTest.FirstLevel firstLevelClass = outerClass.new FirstLevel();
        firstLevelClass.methodInFirstLevel(10);
    }
}
