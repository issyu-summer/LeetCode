package cn.edu.xmu.leetcode.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/">调整数组顺序使奇数位于偶数前面</a><br/>
 * @since 2021/4/6 10:43
 */
public class Main21 {
    /**
     * 遍历
     */
    public int[] exchange(int[] nums) {
        List<Integer> oddList=new ArrayList<>();
        List<Integer> evenList=new ArrayList<>();
        Arrays.stream(nums).forEach(e->{
            if(e%2==0){
                evenList.add(e);
            }else {
                oddList.add(e);
            }
        });
        oddList.addAll(evenList);
        return oddList.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 首尾双指针
     */
    public int[] exchange1(int[] nums) {
        if(nums.length==0){
            return nums;
        }
        int i=0,j=nums.length-1;
        while (i!=j){
            //x&1==1,x是奇数;否则为偶数
            while (i<j&&(nums[i]&1)==1){
                //向后寻找偶数
                i++;
            }
            while (i<j&&(nums[j]&1)==0){
                //向前寻找奇数
                j--;
            }
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        return nums;
    }
}
