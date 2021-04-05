package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author summer
 * @date 2021/3/8 12:10
 */
public class Main59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        int i=0,j=k-1,max=-1;
        for(int tmp=0;tmp<nums.length-k;tmp++){
            for(int temp=i;temp<=j;temp++){
                max=nums[temp+tmp]>max?nums[temp+tmp]:max;
            }
            list.add(max);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Main59_1 main59_1 = new Main59_1();
        int []ar =new int[]{
                1,3,-1,-3,5,3,6,7
        };
        main59_1.maxSlidingWindow(ar, 3);

    }
}
