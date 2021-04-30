package leetcode.clockIn;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">寻找旋转排序数组中的最小值</a><br/>
 * @since 2021/4/8 9:32
 */
public class Main {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=l+((r-l)>>1);
            if(nums[l]<nums[mid]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }
}
