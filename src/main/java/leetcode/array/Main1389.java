package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/create-target-array-in-the-given-order/">按既定顺序创建目标数组</a><br/>
 * @since 2021/4/27 10:32
 */
public class Main1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        int length= nums.length;
        int[] target;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(index[i],nums[i]);
        }
        target=list.stream().mapToInt(Integer::intValue).toArray();
        return target;
    }
}
