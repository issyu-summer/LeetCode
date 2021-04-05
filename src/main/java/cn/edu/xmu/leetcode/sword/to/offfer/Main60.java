package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.Arrays;

/**
 * n个骰子的点数
 * @see <a href="https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/">Dice</a>
 * @author summer
 * @date 2021/4/4 11:55
 */
public class Main60 {

    /**
     * 使用DP统计各种和的个数<br/>
     * n代表骰子数,x代表骰子的总点数<br/>
     * f(n,x)=∑ f(n−1,x−i)*(1/6)   i=1~6
     * @see <a href="https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/">Dice_Solutin</a>
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
