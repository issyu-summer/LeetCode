package leetcode.dp;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/unique-paths/">不同路径</a><br/>
 * @since 2021/4/28 9:39
 */
public class Main62 {
    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];
        dp[0][0]=1;
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
