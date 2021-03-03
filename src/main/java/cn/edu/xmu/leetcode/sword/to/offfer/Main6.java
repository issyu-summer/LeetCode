package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author summer
 * @date 2021/3/1 10:03
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
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
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
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
