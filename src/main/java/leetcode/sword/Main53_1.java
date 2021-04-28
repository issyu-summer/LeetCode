package leetcode.sword;

import java.util.HashMap;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/">在排序数组中查找数字 I</a><br/>
 * @since 2021/4/8 12:43
 */
public class Main53_1 {

    /**
     * 对撞指针,适合有序数组中两个元素的和
     */
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1,count=0;
        while (i<=j){
            if(i!=j) {
                if (nums[i] == target) {
                    count++;
                }
                if (nums[j] == target) {
                    count++;
                }
            }else {
                if(nums[i]==target){
                    count++;
                }
            }
            i++;j--;
        }
        return count;
    }

    /**
     * HashMap
     */
    public int search1(int []nums,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        return map.getOrDefault(target, 0);
    }
    /**
     * 二分
     */
    public int search2(int []nums,int target){
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) {
            return 0;
        }
        // 搜索左边界 left
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;

    }
}
