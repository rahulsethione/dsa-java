package arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @tags: Amazon. SDE-2. Dynamic Programming
 * @description: Find number of all possible combinations of from each set of items such that it does not exceed budget
 */
public class ShoppingCombinations {
    public static void main(String[] args) {
        int[] cpus = {3, 5, 7},
            motherboards = {4, 7, 8},
            gpus = {5, 8},
            ssds = {3};

        int budget = 25;

        int combinations = nonDynamicProgramming(budget, 0, cpus, motherboards, gpus, ssds);

        log(combinations);

        // Test #2
        int[] shirts = { 1, 2 }, pants = { 2, 3 };
        int clothesBudget = 4;

        int results = nonDynamicProgramming(clothesBudget, 0, shirts, pants);

        log(results);
    }

    static void log(Object printable) { System.out.println(printable); }

    static int getAllCombinationsCount(int budget, int fromIndex, int[] ...itemSets) {
        int[][] table = new int[budget + 1][itemSets.length + 1];

        for(int i = 0; i <= budget; i++) {
            Arrays.fill(table[i], -1);
        }

        return dp(budget, 0, table, itemSets);
    }

    private static int dp(int remainingBudget, int fromIndex, int[][] table, int[] ...itemSets) {
        int count = 0;

        if(fromIndex == itemSets.length) {
            if(remainingBudget >= 0)
                return 1;
            else
                return 0;
        } else {
            int[] items = itemSets[fromIndex];

            for(int i = 0; i < items.length; i++) {
                int updatedBudget = remainingBudget - items[i];

                if(updatedBudget >= 0 && table[updatedBudget][fromIndex + 1] > -1) {
                    count = table[updatedBudget][fromIndex + 1];
                } else {
                    count += dp(updatedBudget, fromIndex + 1, table, itemSets);
                    if(updatedBudget >= 0)
                        table[updatedBudget][fromIndex + 1] = count;
                }
            }
        }

        return count;
    }

    static int nonDynamicProgramming(int remainingBudget, int fromIndex, int[] ...itemSets) {
        int count = 0;

        if(fromIndex == itemSets.length) {
            if (remainingBudget >= 0)
                return 1;
            else
                return 0;
        } else {
            for(int value: itemSets[fromIndex]) {
                count += nonDynamicProgramming(remainingBudget - value, fromIndex + 1, itemSets);
            }
        }

        return count;
    }
}
