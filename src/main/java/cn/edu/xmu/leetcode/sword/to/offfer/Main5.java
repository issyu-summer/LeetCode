package cn.edu.xmu.leetcode.sword.to.offfer;

/**
 * @author summer
 * @date 2021/3/1 9:47
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000

 */
public class Main5 {
    public static String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        String s="We are happy.";
        System.out.println(Main5.replaceSpace(s));
    }

}
