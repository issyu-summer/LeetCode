package leetcode.sword;

import java.util.HashMap;

/**
 * @author summer
 * @date 2021/3/3 18:14
 * 数组中出现次数超过一半的数字
 */
public class Main39 {
    //直接使用hashmap统计数字出现的次数
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            if(!map.containsKey(n)){
                map.put(n,1);
            }else {
                map.put(n, map.get(n)+1);
            }
        }
        for(int key:map.keySet()){
            if (map.get(key)>nums.length/2){
                return key;
            }
        }
        return 0;

    }

    /**
     * 使用摩尔投票法,相互抵消
     */
    public int majorityElement1(int[] nums) {
        int x=0,votes=0;
        for (int n:nums
        ) {
            if(votes==0) {
                x=n;
            }
            votes+=n==x?1:-1;
        }
        return x;
    }
}
