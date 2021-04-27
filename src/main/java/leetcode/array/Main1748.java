package leetcode.array;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/sum-of-unique-elements/">唯一元素的和</a><br/>
 * @since 2021/4/26 10:54
 */
public class Main1748 {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int n:nums
             ) {
            if(!map.containsKey(n)){
                map.put(n,1);
            }else {
                map.put(n,map.get(n)+1);
            }
        }
        AtomicInteger sum= new AtomicInteger();
        map.forEach((key,value)->{
            if(value==1) {
                sum.addAndGet(key);
            }
        });
        return sum.get();
    }
}
