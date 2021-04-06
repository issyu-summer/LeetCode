package cn.edu.xmu.leetcode.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/qiu-12n-lcof/solution/">有限制的1+2+3+...+n</a><br/>
 * @author summer
 * @date 2021/3/8 11:26
 */
public class Main64 {
    /**
     * 动态规划
     */
    public int sumNums(int n) {
        int []ar =new int[n+1];
        ar[0]=0;
        for(int i=1;i<=n;i++){
            ar[i]=i+ar[i-1];
        }
        return ar[n];
    }

    /**
     * 递归
     */
    public int sumNums2(int n){
        if(n==1){
            return 1;
        }
        return n + sumNums2(n - 1);
    }

    /**
     * 逻辑符短路终止递归,符号条件
     */
    public int sumNums1(int n) {
        boolean x = n > 1 && (n += sumNums1(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Main64 main64 = new Main64();
        System.out.println(main64.sumNums2(9));
    }
}
