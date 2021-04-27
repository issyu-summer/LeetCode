package cn.edu.xmu.leetcode.sword;

/**
 * @author summer
 * @since  2021/3/3 16:16
 * @see <a href="https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/">二进制中1的个数</a>
 */
public class Main15 {
    public int hammingWeight(int n) {
        //将n循环右移，左边溢出舍去，右边补充0
        int count=0;
        while (n!=0){
            // n & 1 = 1，则 n 二进制 最右一位 为 1
            count+=n&1;
            n>>>=1;
        }
        return count;
    }
}
