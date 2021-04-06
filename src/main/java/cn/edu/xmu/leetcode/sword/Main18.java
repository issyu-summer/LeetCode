package cn.edu.xmu.leetcode.sword;

import java.util.LinkedList;
import java.util.List;

/**
 * @author summer
 * @date 2021/3/2 11:56
 * 删除链表的节点
 */
public class Main18 {

     //Definition for singly-linked list.
    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
        //删除链表的一个节点
        public static ListNode deleteNode(ListNode head, int val) {
            if(head.val==val){
                return head.next;
            }else {
                ListNode pre=head;
                ListNode cur=head.next;
                while (cur!=null){
                    if(cur.val==val){
                        pre.next=cur.next;
                        break;
                    }
                    cur=cur.next;
                    pre=pre.next;
                }
                return head;
            }
        }

    public static void main(String[] args) {
        ListNode node1=new ListNode(4);
        ListNode node2=new ListNode(5);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(9);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        deleteNode(node1,1);

    }

}
