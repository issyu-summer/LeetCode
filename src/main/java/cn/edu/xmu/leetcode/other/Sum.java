package cn.edu.xmu.leetcode.other;

import java.util.*;

/**
 * 两数之和，不是递增数组
 * 递增数组可以使用对撞指针
 * @author summer
 * @date 2021/3/17 21:35
 */
public class Sum {

    public int[] twoSum0(int[] nums, int target) {
        //双循环
        int size=nums.length;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    public int[] twoSum1(int[] nums, int target) {
        //使用哈希表,快速查找是否包含target-x
        int size= nums.length;
        Map<Integer, Integer> map=new HashMap<>(size);
        for(int i=0;i<size;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{
                        map.get(target-nums[i]),i
                };
            }
            map.put(nums[i],i);
        }
        return null;
    }


        public static void main(String[] args) {
        int []nums=new int[]{
                3,2,4
        };
        Sum sum = new Sum();
        System.out.println(Arrays.toString(sum.twoSum0(nums, 6)));
    }
}
