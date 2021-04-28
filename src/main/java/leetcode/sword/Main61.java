package leetcode.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/">判断五张牌是否为顺子</a><br/>
 * @since 2021/4/4 13:45
 */
public class Main61 {

    /**
     * <h>需要满足的条件：</h>
     * <ol>
     *     <li>不重复的五张牌</li>
     *     <li>max-min<5</li>
     * </ol>
     * <h>大小王做任意牌可以忽略。</h>
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int max=0,min=14;
        for (int num : nums) {
            if(num==0){
                continue;
            }
            max= Math.max(max, num);
            min= Math.min(min, num);
            if (!set.add(num)) {
                return false;
            }
        }
        return max - min < 5;
    }

}
