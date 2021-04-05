package cn.edu.xmu.leetcode.sword.to.offfer;

/**
 * @author summer
 * @date 2021/3/8 19:19
 */
public class Main14_1 {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;int tmp=0;
        for(int i = 3; i < n + 1; i++){
            //其中的每一种都是dp[i]
            for(int j = 2; j < i; j++){
                //如果后边长度i-j不剪时乘积比较大，则不减
                if(j*(i-j)>j*dp[i-j]){
                    tmp=j*(i-j);
                }else {
                    tmp=j*dp[i-j];
                }
                //找出dp[i]中最大的。
                dp[i] = Math.max(dp[i], tmp);
            }
        }
        return dp[n];
    }

    //贪心
    public int cuttingRope1(int n) {
        //小于四的时候
        if(n < 4){
            return n - 1;
        }
        if(n==4){
            return 4;
        }
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {
        Main14_1 main14_1 = new Main14_1();
        System.out.println(main14_1.cuttingRope(10));
    }
}
