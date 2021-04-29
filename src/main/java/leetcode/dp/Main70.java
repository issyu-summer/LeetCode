package leetcode.dp;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">爬楼梯</a><br/>
 * @since 2021/4/29 17:32
 */
public class Main70 {

    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int []dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < n; i++) {
            //从之前的1级或2级开始爬
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
