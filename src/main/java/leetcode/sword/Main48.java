package leetcode.sword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/">最长不含重复字符的子字符串 </a><br/>
 * @since 2021/4/28 15:19
 */
public class Main48 {

    /**
     * 使用数组的dp
     */
    public int lengthOfLongestSubstring0(String s) {
        Map<Character,Integer> map=new HashMap<>(){{put(s.charAt(0),0);}};
        int []dp=new int[s.length()];
        dp[0]=1;
        for (int i = 1; i < s.length(); i++) {
            //上次出现的s[i]的位置(index<i)
            int index=map.getOrDefault(s.charAt(i),-1);
            map.put(s.charAt(i),i);
            //如果不在范围内、不会对结果产生影响
            if(i-index>dp[i-1]){
                dp[i]=dp[i-1]+1;
            }else {
                dp[i]=i-index;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 不适用数组的dp
     */
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            // 获取索引 i
            int i = dic.getOrDefault(s.charAt(j), -1);
            // 更新哈希表
            dic.put(s.charAt(j), j);
            // dp[j - 1] -> dp[j]
            tmp = tmp < j - i ? tmp + 1 : j - i;
            // max(dp[j - 1], dp[j])
            res = Math.max(res, tmp);
        }
        return res;
    }

    /**
     * 双指针
     */
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int res=0;int j=-1;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                //最接近的重复字符的位置
                j=Math.max(j,map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i);
            res=Math.max(res,i-j);
        }
        return res;
    }
}
