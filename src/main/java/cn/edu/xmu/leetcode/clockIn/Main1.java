package cn.edu.xmu.leetcode.clockIn;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/">删除有序数组中的重复项 I</a>
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/">删除有序数组中的重复项 II</a><br/>
 * @since 2021/4/6 9:30
 */
public class Main1 {



    /**
     *I
     */
    public static int removeDuplicates1(int[] nums) {
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
    /**
     * II
     */
    public static int removeDuplicates2(int[] nums) {
        int i=2;
        int size=nums.length;
        if(size<=2){
            return size;
        }
        for(int j=2;j<size;j++){
            if(nums[j]!=nums[i-2]){
                nums[i]=nums[j];
                i++;
            }
            //如果相等就会跳过
        }
        return i;
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicates2(new int[]{
                1,1,1,2,2,3
        }));
    }
}
