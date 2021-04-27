package cn.edu.xmu.leetcode.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/">替换空格</a>
 * @author summer
 * @since  2021/3/1 9:47
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
