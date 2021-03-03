package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.List;
import java.util.Stack;

/**
 * @author summer
 * @date 2021/3/2 16:58
 * 反转链表
 */
public class Main24 {
 // Definition for singly-linked list.
 public static class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }

    //使用堆可以反转,但是无法直接相连
    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=head;
        ListNode cur=head.next;
        Stack<ListNode> stack = new Stack<>();
        pre.next=null;
        stack.push(pre);
        while (cur!=null){
            ListNode temp=cur;
            stack.push(cur);
            cur=cur.next;
            temp.next=null;
        }

        ListNode first= stack.pop();
        ListNode tmp=first;
        int size=stack.size();
        for(int i=0;i<size;i++){
            tmp.next=stack.pop();
            tmp=tmp.next;
        }
        return first;
    }

    //https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/jian-zhi-offer-24-fan-zhuan-lian-biao-die-dai-di-2/
    //当成循环链表
    public static ListNode reverseList1(ListNode head) {
     if(head==null){
         return null;
     }
     ListNode pre=null;
     ListNode cur=head;
     ListNode tmp;
     while (cur!=null){
         tmp=cur.next;
         cur.next=pre;
         pre=cur;
         cur=tmp;
     }
     return pre;
    }

    //迭代
    public ListNode reverseList2(ListNode head) {
        return recur(head, null);    // 调用递归并返回
    }
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        reverseList(node1);
    }

}
