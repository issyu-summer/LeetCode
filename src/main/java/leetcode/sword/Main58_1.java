package leetcode.sword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/">翻转单词顺序,不改变单词</a><br/>
 * @author summer
 * @since  2021/4/4 11:18
 */
public class Main58_1 {

    /**
     * 同split分割数组
     */
    public static String reverseWords(String s) {
        s=s.replaceAll("\\s+"," ");
        s=s.trim();
        s+=" ";
        //System.out.println(s);
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        StringBuilder realString = new StringBuilder();
        List<String> list= new ArrayList<>();
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            char aChar = chars[i];
            if (aChar == ' ') {
                list.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(aChar);
            }
        }
        Collections.reverse(list);
        list.forEach(s1-> realString.append(s1).append(" "));
        realString.deleteCharAt(realString.length()-1);
        return realString.toString();
    }

    /**
     * split分割成字符数组
     */
    public String reverseWords1(String s) {
        // 删除首尾空格，分割字符串
        String[] strArr = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        // 倒序遍历单词列表
        for(int i = strArr.length - 1; i >= 0; i--) {
            // 遇到空单词则跳过
            if("".equals(strArr[i])) {
                continue;
            }
            // 将单词拼接至 StringBuilder
            res.append(strArr[i]).append(" ");
        }
        // 转化为字符串，删除尾部空格，并返回
        return res.toString().trim();
    }

    /**
     * 双指针,截取单词
     */
    public String reverseWords2(String s) {
        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            // 搜索首个空格
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            res.append(s, i + 1, j + 1).append(" ");
            // 跳过单词间空格,考虑到了多个空格的情况
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }


    public static void main(String[] args) {
        String s=reverseWords( "the sky is blue");
        System.out.println(s);
    }
}
