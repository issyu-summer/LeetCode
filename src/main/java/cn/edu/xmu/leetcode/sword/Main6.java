package cn.edu.xmu.leetcode.sword;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author summer
 * @since 2021/3/1 10:03
 * @see <a href="https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">从尾到头打印链表</a>
 */
public class Main6 {

     //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
         ListNode(int x) { val = x; }

     }

    /**
     * 辅助栈
     */
    public int[] reversePrint0(ListNode head) {
        Stack<ListNode> stack =new Stack<>();
        ListNode temp=head;
        while (temp.next!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int i=0;
        int [] ar= new int[stack.size()];
        while(!stack.isEmpty()){
            ar[i]=stack.pop().val;
            i++;
        }
        return ar;
    }

    /**
     * 使用递归的方式
     */
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint1(ListNode head) {
        recur(head);
        int[] res;
        res=tmp.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    void recur(ListNode head) {
        if(head == null) {
            return;
        }
        //一直递归到最后一个节点
        recur(head.next);
        tmp.add(head.val);
    }
}
