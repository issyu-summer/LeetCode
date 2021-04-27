package cn.edu.xmu.leetcode.sword;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author summer
 * @since  2021/3/1 11:17
 * @see <a href="https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/">用两个栈实现队列</a>
 */
public class Main9 {


    class CQueue {
        //B存储A的逆序
        LinkedList<Integer> A,B;
        public CQueue() {
            A=new LinkedList<>();
            B=new LinkedList<>();
        }

        public void appendTail(int value) {
            A.addLast(value);
        }

        public int deleteHead() {
            if(!B.isEmpty()){
                return B.removeLast();
            }
            if(A.isEmpty()){
                return -1;
            }
            while (!A.isEmpty()){
                B.addLast(A.removeLast());
            }
            return B.removeLast();
        }
    }
}
