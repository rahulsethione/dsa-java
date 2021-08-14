package numbers;

/**
 * @tags: Morgan Stanley
 */
public class GroupFormation {
    public static void main(String[] args) {
        int people = 7;
        int groups = 3;

        System.out.println(noOfCombinations(people, groups));
        // [(1, 1, 5), (1, 2, 4), (1, 3, 3), (2, 2, 3)]
    }

    static int noOfCombinations(int people, int groups) {
        if(people < groups) {
            return -1;
        }

        int count = 1;
        int[] dist = new int[groups];

        for(int i = 0; i < groups; i++) {
            dist[i] = i == groups - 1 ? people - groups + 1 : 1;
        }

        for (int j = groups - 1; j > 0; j--) {
            while(dist[j] > dist[j-1]) {
                count++;
                dist[j]--;
                dist[j-1]++;
            }
        }

        return count;
    }
}
