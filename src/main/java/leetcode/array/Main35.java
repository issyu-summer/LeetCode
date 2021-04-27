package leetcode.array;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/search-insert-position/"></a><br/>
 * @since 2021/4/24 17:50
 */
public class Main35 {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length;
        while (left<=right){
            int mid=left+((right-left)>>1);
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
}
