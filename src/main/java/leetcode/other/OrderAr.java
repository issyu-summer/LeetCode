package leetcode.other;

/**
 * 有序数组
 * @author summer
 * @date 2021/3/17 23:29
 */
public class OrderAr {
    /**
     * 移除有序数组中的重复数,不使用歪歪空间
     */
    public int removeDuplicates(int[] nums) {
        //i,j双指针
        int i=0;
        int size=nums.length;
        for(int j=1;j<size;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
            //如果相等就会跳过
        }
        return i+1;
    }
}
