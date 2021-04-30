package leetcode.hot;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/">反转链表</a><br/>
 * @since 2021/4/7 0:18
 */
public class Main206 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur=head.next;
        ListNode last=head;
        head.next=null;
        while (cur!=null){
            ListNode tmp=cur.next;
            cur.next=last;
            last=cur;
            cur=tmp;
        }
        return last;
    }

}
