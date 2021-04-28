package leetcode.sword;

/**
 * @author summer
 * @since  2021/3/2 16:14
 * @see <a href="https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/">数值的整数次方</a>
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

    /**
     * 二分、b&1==1（b是奇数）
     * x^n=(x^n)^(n/2)  n为偶数
     * x^n=x(x^n)^(n/2) n为奇数
     */
    public double myPow1(double x, int n) {
        if(x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        //b=-b且x=1/x;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        //会溢出导致n不变
        System.out.println(myPow(2,-2147483648));
    }
}
