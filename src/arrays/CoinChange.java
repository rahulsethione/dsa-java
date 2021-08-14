package arrays;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] denominations = {5, 20, 100};
        int amount = 115;

        int greedyResult = greedy(denominations, amount);
        System.out.println(greedyResult);
    }

    static int greedy(int[] denominations, int amount) {
        int count = 0;

        while(amount > 0) {
            if(amount < denominations[0]) {
                return -1;
            }

            for(int i = denominations.length - 1; i >= 0; i--) {
                if(denominations[i] <= amount) {
                    amount -= denominations[i];
                    count++;
                }
            }
        }

        return count;
    }
}
