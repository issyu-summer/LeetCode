package cn.edu.xmu.leetcode.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author summer
 * @date 2021/3/2 10:57
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main17 {

    //问题的关键在于是否考虑大数字
    public static int[] printNumbers(int n) {
//        List<Integer> list= new ArrayList<>();
        int temp=1;
        for(int i=0;i<n;i++){
            temp*=10;
        }
//        list = IntStream
//                .range(1,n).boxed().collect(Collectors.toList());
        int []ar=IntStream
                .range(1,temp).toArray();
        return ar;

    }

    public static void main(String[] args) {
        int[] ar=printNumbers(1);
        //Arrays.stream(ar).forEach(System.out::println);
        int[] temp=new int[10];
        for(int i=0;i<10;i++){
            temp[i]=i;
        }
        boolean[] bp=new boolean[ar.length];
        StringBuilder s=new StringBuilder();
        dfs(temp);
    }
    private static StringBuilder s=new StringBuilder();

    /**
     * dfs遍历
     * @param p
     */
    public static void dfs(int[] p){
        System.out.println(s);
        if(s.length()==p.length){
            return;
        }
        IntStream.range(0, p.length).forEach(i -> {
            int temp = p[i];
            if (temp != -1) {
                s.append(temp);
                p[i] = -1;
                dfs(p);
                p[i] = temp;
                s.deleteCharAt(s.length() - 1);
            }
        });
    }
}
