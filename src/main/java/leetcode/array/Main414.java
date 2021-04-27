package leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 去重排序
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/third-maximum-number/">第三大的数</a><br/>
 * @since 2021/4/26 10:34
 */
 public class Main414 {
    public int thirdMax(int[] nums) {
        List<Integer> collect =
                Arrays.stream(nums).sorted().distinct().boxed().collect(Collectors.toList());
        return collect.size()<3?collect.get(collect.size()-1):collect.get(collect.size()-3);
    }
}
