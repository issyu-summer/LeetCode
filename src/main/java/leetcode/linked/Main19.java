package leetcode.linked;

import leetcode.data_structure.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">删除链表的倒数第 N 个结点</a><br/>
 * @since 2021/5/1 11:19
 */
public class Main19 {


    /**
     * 允许fast=null,可以避免很多乱七八糟的情况
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtualHead=new ListNode(-1);
        virtualHead.next=head;
        ListNode slow=virtualHead,fast=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return virtualHead.next;
    }


    /**
     * 使用栈
     */
    public ListNode removeNthFromEnd0(ListNode head,int n){
        ListNode dummy = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }
}
