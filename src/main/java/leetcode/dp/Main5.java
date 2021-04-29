package leetcode.dp;

/**
 * 究极算法manacher：O(n)
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">最长回文子串</a><br/>
 * @since 2021/4/29 16:45
 */
public class Main5 {

    /**
     * 暴力枚举
     */
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLen=1,begin=0;
        for (int i = 0; i < chars.length ; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if(j-i+1>maxLen&&valid(chars,i,j)){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    private boolean valid(char[] chars, int left, int right) {
        while (left<right){
            if(chars[left]!=chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 中心扩散
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * 动态规划、去掉收尾仍然是回文-----从内部向外部
     */
    public String longestPalindrome2(String s) {
        int len=s.length();
        if(len<2){
            return s;
        }
        int begin=0,maxLen=1;
        boolean [][]dp=new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        char[] chars = s.toCharArray();
        //模拟子串长度
        for (int l = 2; l <=len; l++) {
            //模拟左边界
            for (int left = 0; left < len; left++) {
                int right=l+left-1;
                if(right>=len){
                    break;
                }
                //首尾不同则一定不是
                if(chars[left]!=chars[right]){
                    dp[left][right]=false;
                }else {
                    //首尾相同,且长度为2或3则一定是
                    if(right-left<3){
                        dp[left][right]=true;
                        //首尾相同,且内部是一个回文串,则一定是
                    }else {
                        dp[left][right]=dp[left+1][right-1];
                    }
                }
                if(dp[left][right] &&right-left+1>maxLen){
                    maxLen=right-left+1;
                    begin=left;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

}
