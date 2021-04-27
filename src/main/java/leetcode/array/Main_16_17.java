package leetcode.array;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/25 15:42
 */
public class Main_16_17 {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
