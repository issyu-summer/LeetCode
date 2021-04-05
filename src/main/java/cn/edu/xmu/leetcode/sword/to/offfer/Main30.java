package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.Stack;

/**
 * @author summer
 * @date 2021/3/8 18:50
 */
public class Main30 {
    class MinStack {

        //A为实际栈，B为A的非严格递减栈,向上肯定不是最小值，只有向下才有可能是，同理，大的栈也是如此
        Stack<Integer>  A,B;
        /** initialize your data structure here. */
        public MinStack() {
            A=new Stack<>();
            B=new Stack<>();
        }

        public void push(int x) {
            A.add(x);
            //B为空的时候可以直接放入
            if(B.isEmpty()||B.peek()>=x){
                B.add(x);
            }
        }

        //A一定pop,但B不一定
        public void pop() {
            if(B.peek().equals(A.pop())){
                B.pop();
            }
        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
