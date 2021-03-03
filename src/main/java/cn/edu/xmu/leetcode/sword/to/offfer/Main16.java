package cn.edu.xmu.leetcode.sword.to.offfer;

/**
 * @author summer
 * @date 2021/3/2 16:14
 * 数值的整数次方，包括符数
 */
public class Main16 {

    //使用二分法和二进制

    //使用循环代替次方

    public static double myPow(double x, int n) {
        if(x==-1.0){
            if(n%2==0){
                return 1.0;
            }else {
                return -1.0;
            }
        }
        else if(n==0||x==1.0){
            return 1;
        }else
        if(n>0){
            double tmp=1;
            for(int i=0;i<n;i++){
                tmp*=x;
            }
            return tmp;
        }else {
            //需要考虑负数的绝对值位数溢出问题
            double tmp=1;
            //优化1
            for(int i=n;i<0;i++){
                tmp*=x;
                //优化2
                if(1.0/tmp-0.00001<0){
                    return 0;
                }
            }

            return 1.0/tmp;
        }
    }

    public static void main(String[] args) {
        //会溢出导致n不变
        System.out.println(myPow(2,-2147483648));
    }
}
