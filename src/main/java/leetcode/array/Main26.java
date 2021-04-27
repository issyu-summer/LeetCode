package leetcode.array;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/24 14:24
 */
public class Main26 {

    public int removeDuplicates(int[] nums) {
        int slow=0;
        int fast=1;
        for(;fast< nums.length;fast++){
            if(nums[fast]!=nums[slow]){
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;
    }
}
