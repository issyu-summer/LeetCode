package cn.edu.xmu.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * @author summer
 * @date 2021/3/4 16:15
 */
public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        HashSet<Integer> setClone;
        setClone= (HashSet<Integer>) set.clone();
        setClone.forEach(System.out::println);
        Stream<String> stream = Stream.of("fads","asdfs","fasdfsa");
        set.clear();
        set.forEach(System.out::println);
        set.add(25);
        set.add(21);
        Integer[] ar=new Integer[set.size()];
        ar=set.toArray(ar);
        Arrays.stream(ar).forEach(System.out::println);
    }
}
