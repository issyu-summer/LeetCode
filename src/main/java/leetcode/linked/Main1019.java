package leetcode.linked;

import leetcode.data_structure.ListNode;

import java.util.*;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/next-greater-node-in-linked-list/">链表中的下一个更大节点链表中的下一个更大节点</a><br/>
 * @since 2021/5/1 23:15
 */
public class Main1019 {

    /**
     * 使用栈
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        //栈中存储的是元素的下标，并且从栈底到栈顶元素在集合中对应的
        //值是从大到小的
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.empty() && list.get(stack.peek()) < list.get(i)) {
                //如果栈顶元素对应的值小于当前值，说明栈顶元素遇到了恰好比他大的下一个值
                int index = stack.pop();
                res[index] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
