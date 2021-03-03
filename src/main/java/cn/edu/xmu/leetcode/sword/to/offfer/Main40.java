package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author summer
 * @date 2021/3/3 19:46
 * 最小的k个数
 */
public class Main40 {
    //直接排序
    public int[] getLeastNumbers(int[] arr, int k) {
        List<Integer> list=
                Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
        int[]ar=new int[k];
        IntStream.range(0,k).forEach(i->{
            ar[i]=list.get(i);
        });
        return ar;
    }
}
