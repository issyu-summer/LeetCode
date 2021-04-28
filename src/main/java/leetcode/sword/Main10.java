package leetcode.sword;

/**
 * @author summer
 * @since  2021/3/1 19:04
 * @see <a href="https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/">斐波那契数列</a>
 */
public class Main10 {

    //10-1
    public int fib(int n) {
        if(n==0) {
            return 0;
        }else if(n==1){
            return 1;
        }
        int[] dp =new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
           dp[i]=dp[i-1]+dp[i-2];
           if(dp[i]>1000000007){
               dp[i]=Math.floorMod(dp[i],1000000007);
           }
        }
        return dp[n];
    }
    //10-2青蛙跳台阶

    public int numWays(int n) {
        return fib(n);
    }
}
