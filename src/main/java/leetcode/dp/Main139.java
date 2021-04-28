package leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/word-break/">单词拆分</a><br/>
 * @since 2021/4/28 9:11
 */
public class Main139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        boolean []dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                //dp[j]:s[0...j-1]、subString(j,i):s[j...i]
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
