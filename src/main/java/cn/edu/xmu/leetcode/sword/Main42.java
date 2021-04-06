package cn.edu.xmu.leetcode.sword;

/**
 * @author summer
 * @date 2021/3/3 19:53
 * 连续子数组的最大和
 */
public class Main42 {
    //题意理解错了
    public static int maxSubArray(int[] nums) {
        //连续子数组的最大和
        int []ar=new int[nums.length];
        ar[2]=nums[0]+nums[1];
        int max=ar[2];
        for(int i=3;i<nums.length;i++){
            ar[i]=ar[i-1]+nums[i-1];
            if(ar[i]>max){
                max=ar[i];
            }
        }
        return max;
    }


    public static int maxSubArray1(int[] nums) {
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i=1;i<nums.length;i++){
            //使用动态规划
            dp[i]=nums[i]+Math.max(dp[i-1],0);
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    //使用nums作为额外空间的动态规划
    public static int maxSubArray2(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i]+=Math.max(nums[i-1],0);
            max=Math.max(max,nums[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int []nums=new int[]{
                -2,1,-3,4,-1,2,1,-5,4
        };
        System.out.println(maxSubArray1(nums));
    }
}
