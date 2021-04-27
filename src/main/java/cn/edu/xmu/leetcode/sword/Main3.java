package cn.edu.xmu.leetcode.sword;

import java.util.HashSet;

/**
 * @see <a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">数组中重复的数字</a>
 * @author summer
 * @since  2021/3/1 8:06
 */

public class Main3 {
    /**
     * 适用于任何重复数字
     * HashSet中的值唯一
     */
    public static int findRepeatNumber0(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int n:nums){
            if(!hashSet.add(n)){
                return n;
            }
        }
        return 0;
    }

    /**
     * 适用于任何重复数字问题。甚至可以统计重复数字的次数
     * 记录数字出现的次数,题目给出了范围,所以不会出现重复。
     * 使用hashMap
     */
    public static int findRepeatNumber1(int[] nums) {
       int[] arr =new int[nums.length];
       for(int n:nums){
           arr[n]++;
           if(arr[n]>1){
               return n;
           }
       }
        return 0;
    }

    /**
     * 适用于：在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
     * 原地置换对于0~n-1来说,nums[i]=i一定成立
     */
    public static int findRepeatNumber2(int[] nums) {
       int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                temp=nums[i];
                if(temp==nums[temp]){
                    return temp;
                }
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={
                0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        };
        System.out.println(Main3.findRepeatNumber2(nums));
    }
}
