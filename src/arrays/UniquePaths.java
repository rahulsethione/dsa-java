package arrays;

public class UniquePaths {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];
        for(int i = 0; i < m; i++) table[i][n-1] = 1;
        for(int j = 0; j < n; j++) table[m-1][j] = 1;
        // move(m, n, 0, 0, table);
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                table[i][j] = table[i+1][j] + table[i][j+1];
            }
        }
        return table[0][0];

    }

    private int move(int m, int n, int i, int j, int[][] table) {
        if(i == m - 1 || j == n - 1) return table[i][j];

        table[i][j] = move(m, n, i + 1, j, table) + move(m, n, i, j + 1, table);
        return table[i][j];
    }
}
