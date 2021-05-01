package leetcode.linked;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/">交换链表中的节点</a><br/>
 * @since 2021/5/1 9:31
 */
public class Main1721 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 快慢双指针找到k和倒数第K个<br/>
     * 交换val即可
     */
    public ListNode swapuNodes(ListNode head, int k) {
        ListNode nodeK = new ListNode(-1),recipNodeK= new ListNode(-1),tmpNodeA=head,tmpNodeB=head;
        while (tmpNodeA!=null){
            if(k==1){
                nodeK=tmpNodeA;
            }
            if(k<=0){
                tmpNodeB=tmpNodeB.next;
            }
            tmpNodeA=tmpNodeA.next;
            k--;
        }
        recipNodeK=tmpNodeB;
        int num=nodeK.val;
        nodeK.val=recipNodeK.val;
        recipNodeK.val=num;
        return head;
    }
}
