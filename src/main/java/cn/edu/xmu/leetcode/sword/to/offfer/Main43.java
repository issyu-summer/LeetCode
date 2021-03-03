package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author summer
 * @date 2021/3/3 20:30
 * 1到n中1出现的次数
 */
public class Main43 {
    //转化乘字符串，暴力搜索，内存超限制
    public static int countDigitOne(int n) {
        List<String> list
                = IntStream.range(1,n+1).mapToObj(String::valueOf).collect(Collectors.toList());
        StringBuilder s=new StringBuilder();
        list.forEach(s1 -> s.append(s1));
        Map<String, Long> collect
                = Stream.of(s.toString().split("")).collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        if(collect.containsKey("1")){
            return Math.toIntExact(collect.get("1"));
        }
        return 0;
    }
    //利用该为出现1的次数来解决
    public static int countDigitOn1(int n) {
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(countDigitOne(3184191));
    }
}
