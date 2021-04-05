package cn.edu.xmu.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 781：兔子最少的数量
 * @link https://leetcode-cn.com/problems/rabbits-in-forest/
 * @author summer
 * @date 2021/4/4 10:40
 */
public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        if(answers.length==0){
            return 0;
        }
        //兔子颜色的种类不会超过兔子的个数
        Map<Integer,Integer> map=new HashMap<>(answers.length);
        //统计回答的种类及个数
        for(int rabbit:answers){
            map.put(rabbit,map.getOrDefault(rabbit,0)+1);
        }
        int ans=0;
        for(int key: map.keySet()){
            int x=map.get(key);
            ans += ((x + key) / (key + 1)) * (key + 1);
        }
        return ans;
    }
}
