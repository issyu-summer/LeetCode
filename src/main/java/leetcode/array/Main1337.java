package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 无意义的题目<br/>
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/">矩阵中战斗力最弱的 K 行</a><br/>
 * @since 2021/4/26 10:43
 */
public class Main1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int col=mat[0].length;
        int j=0;int count=0;
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int[] ints = mat[i];
            while (j < col) {
                if (ints[j] == 1) {
                    count++;
                    j++;
                } else {
                    list.add(count);
                    map.put(count,i);
                    j = 0;
                    count = 0;
                    break;
                }
            }
        }
        list=list.stream().sorted().collect(Collectors.toList());
        int first=list.get(0);
        int next=list.get(1);
        int last=list.get(2);
        return new int[]{
                map.get(first),map.get(next),map.get(last)
        };
    }
}
