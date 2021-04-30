package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/single-number-ii/">只出现一次的数字 II</a><br/>
 * @since 2021/4/30 12:08
 */
public class Main137 {

    public int singleNumber(int[] nums) {
        //元素,次数
        Map<Integer,Boolean> map=new HashMap<>();
        for (int n:nums
             ) {
            if(!map.containsKey(n)){
                map.put(n,true);
            }else {
                map.put(n,false);
            }
        }
        for (Integer key: map.keySet()
             ) {
            if(map.get(key)){
                return key;
            }
        }
        return 0;
    }
}
