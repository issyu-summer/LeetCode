package cn.edu.xmu.leetcode.sword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author summer
 * @since  2021/3/3 16:30
 * @see <a href="https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/">字符串的排列</a>
 */
public class Main38 {

    private static HashSet<String> set=new HashSet<>();

    //全排列，含重复的
    public static  String[] permutation(String s) {
        char [] ar =s.toCharArray();
        dfs(ar,new StringBuilder());
        //或者使用hsahSet去重
        //list=list.stream().distinct().collect(Collectors.toList());
        return set.toArray(new String[]{});
    }

    public  static void dfs(char[] ar, StringBuilder s){
        if(s.length()==ar.length){
            set.add(s.toString());
            return;
        }
        HashSet<Character> set=new HashSet<>();
        for (int j = 0; j < ar.length; j++) {
            char tmp = ar[j];
            if (set.contains(tmp)) {
                continue;
            }
            set.add(tmp);
            if (ar[j] != '\0') {
                s.append(tmp);
                ar[j] = '\0';
                dfs(ar, s);
                ar[j] = tmp;
                s.deleteCharAt(s.length() - 1);
            }
        }
    }


    /**
     *全排列的固定位置交换法
     */
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation1(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));
            // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) {
                continue;
                // 重复，因此剪枝
            }
            set.add(c[i]);
            swap(i, x);
            // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);
            // 开启固定第 x + 1 位字符
            swap(i, x);
            // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    public static void main(String[] args) {
        String s="aab";
        String[]ar=permutation(s);
        System.out.println();
    }
}
