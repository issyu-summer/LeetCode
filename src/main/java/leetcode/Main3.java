package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">无重复字符的最长子串</a><br/>
 * @since 2021/4/25 17:32
 */
public class Main3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left=0,right=0;
        int ans=0;
        Map<Character,Integer> map
                =new HashMap<>();
        for (; right < chars.length ; right++) {
            char tmp=chars[right];
            if(map.containsKey(tmp)){
                //边界情况、abba、最后一个right时、a对应的下标是1、导致r-l+1=3发生错误
                left=Math.max(map.get(tmp),left);
            }
            ans=Math.max(ans,right-left+1);
            map.put(chars[right],right+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Main3 main3 = new Main3();
        System.out.println(main3.lengthOfLongestSubstring("abcabcbb"));
    }
}
