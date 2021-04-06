package cn.edu.xmu.leetcode.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/">和为s的两个数字</a><br/>
 * @author summer
 * @since  2021/3/2 17:52
 */
public class Main57 {

    /**
     * 遍历,时间超限
     */
    public int[] twoSum(int[] nums, int target) {
        for (int n:nums
             ) {
            if(n>=target){
                n=0;
            }
        }
        int[] ar=new int[2];
        for(int n:nums){
            for(int m:nums){
                if(n!=0&&m!=0) {
                    if (n + m == target) {
                        ar[0] = n;
                        ar[1] = m;
                    }
                }
            }
        }
        return ar;
    }

    /**
     * 排序数组,使用对撞指针
     */
    public int[] twoSum1(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while (i<j){
            int sum=nums[i]+nums[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else {
                return new int[]{nums[i],nums[j]};
            }
        }
        return null;
    }


        public static void main(String[] args) {

    }
}
