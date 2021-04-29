package leetcode.dp;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/frog-jump/">青蛙过河</a><br/>
 * @since 2021/4/29 15:50
 */
public class Main403 {

    /**
     * 动态规划
     */
    public boolean canCross(int[] stones) {
        int length=stones.length;
        boolean [][]dp=new boolean[length][length];
        dp[0][0]=true;
        for (int i = 1; i < length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                int k=stones[i]-stones[j];
                if(k>j+1){
                    break;
                }
                dp[i][k]=dp[j][k-1]||dp[j][k]||dp[j][k+1];
                if(i==length-1&&dp[i][k]){
                    return true;
                }
            }
        }
        return false;
    }
}
