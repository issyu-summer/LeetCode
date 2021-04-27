package leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/valid-triangle-number/">有效三角形的个数</a><br/>
 * @since 2021/4/27 11:32
 */
public class Main611 {

    public int triangleNumber(int[] nums) {
       Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k=i+2;
            for (int j = 0; j < i + 1; j++) {
//                while (k<nums.length&&nums[i]){
//
//                }
            }
        }
        return 0;
    }
}
