package cn.edu.xmu.leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/single-number/">只出现一次的数字</a><br/>
 * @since 2021/4/7 0:03
 */
public class Main136 {

    /**
     * 异或
     */
    public static int singleNumber(int[] nums) {
        int num=0;
        for(int n:nums){
            num^=n;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] ints = {
                2,2,1
        };
        System.out.println(singleNumber(ints));
    }
}
