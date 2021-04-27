package cn.edu.xmu.leetcode.sword;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/">股票的最大利润</a><br/>
 * @since 2021/4/27 22:02
 */
public class Main63 {
    public int maxProfit(int[] prices) {
        int length=prices.length;
        if(length==0){
            return 0;
        }
        int []dp=new int[length];
        dp[0]=0;
        int cost=prices[0];
        for (int i = 1; i < length; i++) {
            cost=Math.min(cost,prices[i]);
            dp[i]=Math.max(dp[i-1],prices[i]-cost);
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        Main63 main63=new Main63();
        System.out.println(main63.maxProfit(new int[]{1,2}));
    }
}
