package datatypes;

import java.util.stream.Collectors;

public class Arrays {
    private static void log(Object printable) { System.out.println(printable); }

    public static void main(String[] args) {
        // An array is a subclass of the Object class with fixed number of elements
        String[] animals = new String[] {"Dog", "Sheep", "Wolf", "Cat", "Tiger", "Elephant"};
        String[] animalsRef = animals;
        String[] animalsCopy = new String[] {"Dog", "Sheep", "Wolf", "Cat", "Tiger", "Elephant"};
        String[] animalsClone = animals.clone();

        log(animals == animalsRef); // true
        log(animals.equals(animalsCopy)); // false
        log(java.util.Arrays.stream(animalsClone).collect(Collectors.joining(", ")));

        int count = 0;

//        Runnable runnable = () -> {
//            System.out.println(animals[count] + " " + Thread.currentThread().getName());
//        };

//        Thread thread = new Thread(runnable);

//        thread.run();
    }


}
