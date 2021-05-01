package leetcode.linked;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/swap-nodes-in-pairs/">两两交换链表中的节点</a><br/>
 * @since 2021/5/1 10:20
 */
public class Main24 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 虚拟头节点、迭代
     */
    public ListNode swapPairs(ListNode head) {
        ListNode virtualHead=new ListNode(-1);
        virtualHead.next=head;
        ListNode tmp=virtualHead;
        while (tmp.next!=null&&tmp.next.next!=null){
            ListNode node1=tmp.next;
            ListNode node2=tmp.next.next;
            tmp.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            tmp=node1;
        }
        return virtualHead.next;
    }

    /**
     * 递归
     */
    public ListNode swapPairs1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=head.next;
        head.next=swapPairs(newHead.next);
        newHead.next=head;
        return newHead;
    }


}
