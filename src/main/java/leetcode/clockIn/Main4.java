package leetcode.clockIn;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/">搜索旋转排序数组</a><br/>
 * @since 2021/4/7 22:25
 */
public class Main4 {
    /**
     * 不重复的的旋转数组
     */
    public static int search(int[] nums, int target) {
        int size=nums.length;
        if(size==0){
            return -1;
        }
        if(size==1&&nums[0]==target){
            return 0;
        }
        int l=0,r=size-1;
        //小于等于
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]==target){
                return mid;
            }
            //对有序的部分使用二分,如果前半部分是有序的
            if(nums[l]<=nums[mid]){
                if(nums[l]<=target&&target<=nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
                //如果后半部分是有序的
            }else {
                if(nums[mid]<=target&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{
                4,5,6,7,0,1,2
        },0));
    }
}
