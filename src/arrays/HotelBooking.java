package arrays;

import java.util.Arrays;

/**
 * @tags: Goldman Sachs, Microsoft
 */
public class HotelBooking {
    public static void main(String[] args) {
//        int[] arrivals = {1, 3, 5};
//        int[] departures = {2, 6, 8};
//        int rooms = 1;

        int[] arrivals = {1, 2, 4, 7};
        int[] departures = {5, 3, 10, 9};
        int rooms = 2;

        boolean result = capacity(arrivals, departures, rooms);
        System.out.println(result);
        return;
    }

    static boolean capacity(int[] arrivals, int[] departures, int rooms) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int vacantRooms = rooms - 1;
        int p = 0;

        for(int k = 1; k < arrivals.length; k++) {

            while(vacantRooms >= 0 && vacantRooms < rooms && arrivals[k] >= departures[p]) {
                p++;
                vacantRooms++;
            }

            if(vacantRooms > 0) {
                vacantRooms--;
            } else {
                return false;
            }
        }

        return true;
    }
}
