package leetcode.array;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/24 14:30
 */
public class Main27 {

    public int removeElement(int[] nums, int val) {
        int slow=0,fast=0;
        for (  ; fast < nums.length ; fast++) {
            if(nums[fast]!=val){
                nums[++slow]=nums[fast];
            }
        }
        return slow+1;
    }
}
