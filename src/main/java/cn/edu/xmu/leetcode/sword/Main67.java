package cn.edu.xmu.leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/">字符串转换成整数</a><br/>
 * @since 2021/4/4 13:58
 */
public class Main67 {

    /**
     * @see <a href="https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/solution/mian-shi-ti-67-ba-zi-fu-chuan-zhuan-huan-cheng-z-4/">
     *     solution
     *     </a>
     */
    public int strToInt(String str) {
        str=str.trim();
        char[] chars = str.toCharArray();
        if(chars.length==0){
            return 0;
        }
        int res=0,boundary=Integer.MAX_VALUE/10;
        int i = 1, sign = 1;
        if(chars[0] == '-') {
            sign = -1;
        }
        else if(chars[0] != '+') {
            i = 0;
        }
        for(int j = i; j < chars.length; j++) {
            if(chars[j] < '0' || chars[j] > '9') {
                break;
            }
            if(res > boundary || res == boundary && chars[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chars[j] - '0');
        }
        return sign * res;
    }
}
