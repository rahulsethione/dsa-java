package collections;

import java.util.HashMap;
import java.util.Map;

public class HashmapTest {
    public static void main(String[] args) {
        Map<Point, String> map = new HashMap<>();

        map.put(new Point(5, 10), "Venus"); // O(1)
        map.put(new Point(10, 15), "Mars"); // O(1)
        map.put(new Point(17, 13), "Jupiter"); // O(1)
        map.put(new Point(13, 17), "Saturn"); // O(2)
        map.put(new Point(12, 18), "Pluto"); // O(3)

        log(map.get(new Point(17, 13))); // O(n) => Jupiter
        log(map.get(new Point(12, 18))); // O(n) => Pluto
        log(map.get(new Point(10, 20))); // O(n) => null

        map.remove(new Point(13, 17)); // O(n) => Removing Saturn

        log(map.get(new Point(17, 13))); // O(n) = O(2) => Jupiter

    }

    static void log(Object printable) { System.out.println(printable); }
}
