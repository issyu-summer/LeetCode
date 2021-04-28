package leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/">两个链表的第一个公共节点</a><br/>
 * @since 2021/4/12 18:14
 */
public class Main52 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    /**
     * 双指针
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA=headA;ListNode tmpB=headB;
        while (tmpA!=tmpB){
            tmpA=tmpA!=null?tmpA.next:headB;
            tmpB=tmpB!=null?tmpB.next:headA;
        }
        return tmpA;
    }

}
