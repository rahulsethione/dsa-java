package lambdafunctions;

import java.util.function.Consumer;

public class LambdaTest {
    public int field = 1;
    class FirstLevel {
        public int field = 2;
        void methodInFirstLevel(int arg) {
            int localVariable = 7;
            Consumer<Integer> myConsumer = (field) -> {   // Lambda Expression
                System.out.println(field + localVariable);
                System.out.println("Argument = " + arg);
                System.out.println("this.field = " + this.field);
                System.out.println("LambdaTest.this.field = " + LambdaTest.this.field);
            };
            myConsumer.accept(arg);
        }
    }

    public static void main(String args[]) {
        final LambdaTest outerClass = new LambdaTest();
        final LambdaTest.FirstLevel firstLevelClass = outerClass.new FirstLevel();
        firstLevelClass.methodInFirstLevel(10);
    }
}
