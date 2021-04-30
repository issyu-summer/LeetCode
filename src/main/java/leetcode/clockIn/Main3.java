package leetcode.clockIn;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/">搜索旋转排序数组 II</a><br/>
 * @since 2021/4/7 22:19
 */
public class Main3 {
    /**
     * 二分查找,同旋转数组最小值
     */
    public boolean search(int[] nums, int target) {
        int length=nums.length;
        if(length==0){
            return false;
        }
        if(length==1&&nums[0]==target){
            return true;
        }
        int l=0,r=length-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]==target){
                return true;
            }
            //无法判断哪部分有序,但此处的mid一定不是
            if(nums[l]==nums[mid]&&nums[mid]==nums[r]){
                ++l;
                --r;
                //
            }else if(nums[l]<=nums[mid]){
                if(nums[l]<=target&&target<=nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if(nums[mid]<=target&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return false;
    }
}
