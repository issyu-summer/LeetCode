package cn.edu.xmu.leetcode.sword.to.offfer;

/**
 * @see <a href="https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/">25:合并两个有序列表</a><br/>
 * @author summer
 * @date 2021/3/19 12:04
 */
public class Main25 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    }

    /**
     * 合并两个有序链表
     * 有序,可以考虑使用双指针
     * 顺序双指针
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode virtualHead = new ListNode(-1);
        ListNode cur=virtualHead;
        ListNode remainList = null;
        while (l1!=null&&l2!=null){
            //谁小谁在前
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
            if(l2==null){
                remainList=l1;
            }else {
                remainList=l2;
            }
        }
        cur.next=remainList;
        return virtualHead.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l11=new ListNode(2);
        ListNode l12=new ListNode(4);
        l1.next=l11;l11.next=l12;
        ListNode l2=new ListNode(1);
        ListNode l21=new ListNode(3);
        ListNode l22=new ListNode(4);
        l2.next=l21;l21.next=l22;

        ListNode head=mergeTwoLists(l1,l2);
        System.out.println(head.toString());



    }

}
