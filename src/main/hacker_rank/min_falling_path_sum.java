import java.util.Arrays;

public class min_falling_path_sum {
    public static void main(String[] args) {
        System.out.println(new min_falling_path_sum().minFallingPathSum(
                new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                }
        ));
    }

    public int minFallingPathSum(int[][] A) {
        int n = A.length;

        int[][] dp = new int[n][n];


        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1) {
                    dp[i][j] = A[i][j];
                } else if (j == n - 1) {
                    dp[i][j] = A[i][j] + Math.min(dp[i + 1][j - 1], dp[i + 1][j]);
                } else if (j == 0) {
                    dp[i][j] = A[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = A[i][j] + Math.min(Math.min(dp[i + 1][j - 1], dp[i + 1][j]), dp[i + 1][j + 1]);
                }
            }
        }
        Arrays.sort(dp[0]);

        return dp[0][0];
    }
}
