package cn.edu.xmu.leetcode.sword.to.offfer;

/**
 * @author summer
 * @date 2021/3/3 16:16
 * 二进制中1的个数
 */
public class Main15 {
    public int hammingWeight(int n) {
        //将n循环右移，左边溢出舍去，右边补充0
        int count=0;
        while (n!=0){
            count+=n&1;
            n>>>=1;
        }
        return count;
    }
}
