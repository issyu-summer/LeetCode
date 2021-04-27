package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/25 17:06
 */
public class Main1 {
    /**
     * 有序
     */
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while (i<=j){
            int sum=nums[i]+nums[j];
            if(sum==target){
                return new int[]{
                        i,j
                };
            }else if(sum<target){
                i++;
            }else {
                j--;
            }
        }
        return new int[2];
    }

    /**
     * 无序
     */
    public int[] twoSum1(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n=nums[i];
            if(map.containsKey(n)){
                return new int[]{
                        map.get(n),i
                };
            }
            map.put(target-n,i);
        }
        return new int[2];
    }
}
