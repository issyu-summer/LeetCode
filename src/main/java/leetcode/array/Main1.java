package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/24 13:59
 */
public class Main1 {

    public int[] twoSum(int[] nums, int target) {
        //（数值、索引）
        HashMap<Integer,Integer> map
                =new HashMap<>();
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int n = nums[i];
            if(!map.containsKey(n)) {
                map.put(target - n, i);
            }else {
                return new int[]{
                        i,map.get(n)
                };
            }
        }
        return new int[2];
    }
}
