package leetcode.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/">第一个只出现一次的字符</a><br/>
 * @since 2021/4/8 11:57
 */
public class Main50 {
    /**
     * HashMap存储频数
     */
    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Boolean> map=new HashMap<>();
        for (char aChar : chars) {
           map.put(aChar,!map.containsKey(aChar));
        }
        //按序遍历
        for(Character c:chars){
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
