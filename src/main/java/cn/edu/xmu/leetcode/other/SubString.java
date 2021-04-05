package cn.edu.xmu.leetcode.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 无重复最长子串
 * @author summer
 * @date 2021/3/17 21:51
 */
public class SubString {

    public int lengthOfLongestSubstring(String s) {
        //使用滑动窗口,可以记录窗口的长度,即子串的长度,使用哈希表可以去重
        int size=s.length();int ans=0;
        //HashSet<Byte> hashSet= new HashSet<>();
        Map<Byte,Integer> map=new HashMap<>(size);
        byte [] bytes=s.getBytes();
        int left=0;int right=0;
        for(;right<size;right++){
            if(map.containsKey(bytes[right])){
                left=Math.max(map.get(bytes[right]),left);
            }
            ans=Math.max(ans,right-left+1);
            map.put(bytes[right],right+1);
        }
        return ans;
    }
}
