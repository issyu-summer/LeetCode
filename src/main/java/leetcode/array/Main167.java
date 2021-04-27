package leetcode.array;

/**
 * 递增双指针
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">两数之和 II - 输入有序数组</a><br/>
 * @since 2021/4/26 10:27
 */
public class Main167 {
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right= numbers.length-1;
        while (left<right){
            if(numbers[left]+numbers[right]==target){
                return new int[]{
                        left+1,right+1
                };
            }else if(numbers[left]+numbers[right]<target){
                left++;
            }else {
                right--;
            }
        }
        return new int[2];
    }
}
