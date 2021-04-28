package leetcode.sword;

import java.util.Stack;

/**
 * @author summer
 * @since  2021/3/8 18:31
 * @see <a href="https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/">栈的压入、弹出序列</a>
 */
public class Main31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0,j=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Main31 main31 =new Main31();
        int [] pushed=new int[]{
                1,2,3,4,5
        };
        int [] poped=new int[]{
                4,5,3,2,1
        };
        main31.validateStackSequences(pushed,poped);
    }
}
