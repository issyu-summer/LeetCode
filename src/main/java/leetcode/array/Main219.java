package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/25 15:10
 */
public class Main219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        k=nums.length-k>0?k:nums.length-1;
        //维护一个大小为k+1的滑动窗口
        for(int i=0;i<nums.length-k;i++){
            for(int j=i;j<k+i+1;j++){
                if(!set.add(nums[j])){
                    return true;
                }
            }
            set=new HashSet<>();
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main219 main219=new Main219();
        System.out.println(main219.containsNearbyDuplicate(new int[]{
                99,99
        },2));
    }
}
