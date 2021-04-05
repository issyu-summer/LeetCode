package cn.edu.xmu.leetcode.coolectTest;

import lombok.val;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author summer
 * @date 2021/3/19 13:12
 */
public class Main {
    public static void main(String[] args) {
        Book book1=new Book().setName("三国演义1").setPrice(12);
        Book book2=new Book().setName("三国演义2").setPrice(122);
        Book book3=new Book().setName("三国演义3").setPrice(2);
        Book book4=new Book().setName("三国演义4").setPrice(14542);

        List<Book> books =new LinkedList<>(){{
            add(book1);
            add(book2);
            add(book3);
            add(book4);}};
        books=books.stream()
                .sorted(Comparator.comparing(Book::getPrice)).collect(Collectors.toList());
        books.forEach(e-> System.out.println(e.toString()));
    }
}
