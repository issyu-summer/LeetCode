package leetcode.other;

/**
 * @author summer
 * @date 2021/3/17 22:03
 */
public class Max {

    /**
     * 最大连续子数组和---贪心
     * 当子数组和为负数时立刻放弃
     */
    public int maxSubArray(int[] nums) {
        int sum=nums[0];int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    /**
     * 最大连续数组和---Dp
     */
    public int maxSubArrayDp(int []nums){
        int size=nums.length;
        int max=nums[0];
        int sum=nums[0];
        for(int i=1;i<size;i++){
            sum=Math.max(nums[i]+sum,nums[i]);
            max=Math.max(max,sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Max max = new Max();
        int[] ints = {
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };
        System.out.println(max.maxSubArray(new int[]{
                -2
        }));
        System.out.println(max.maxSubArrayDp(ints));
    }
}
