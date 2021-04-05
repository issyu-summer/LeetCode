package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.stream.IntStream;

/**
 * @author summer
 * @date 2021/3/19 11:08
 */
public class Main58_2 {
    /**
     * 分割字符串
     */
    public String reverseLeftWords(String s, int n) {
        //不包括n
        String s1 = s.substring(0, n);
        System.out.println(s1);
        //从n开始到结尾
        String s2 = s.substring(n);
        System.out.println(s2);
        return s2+s1;
    }

    /**
     * 遍历,java8的流式编程
     */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder stringBuilder=new StringBuilder();
        IntStream
                .range(n, s.length())
                .mapToObj(s::charAt)
                .forEachOrdered(stringBuilder::append);

        IntStream
                .range(0, n)
                .mapToObj(s::charAt)
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }


        public static void main(String[] args) {
        Main58_2 main58 = new Main58_2();
        System.out.println(main58.reverseLeftWords2("abcdefg",2));
    }
}
