package cn.edu.xmu.leetcode.hot;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">合并两个有序列表,同🗡25</a><br/>
 * @since 2021/4/4 20:26
 */
public class Main21 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 合并有序列表,虚拟头节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode virtualHead=new ListNode();
        ListNode node1=l1;
        ListNode node2=l2;
        if(l1==null) {
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode tmp=virtualHead;
        while (node1!=null&&node2!=null){
            if(node1.val<node2.val){
                tmp.next=node1;
                node1=node1.next;
            }else {
                tmp.next=node2;
                node2=node2.next;
            }
            tmp= tmp.next;
        }
        if(node1!=null){
            tmp.next=node1;
        }else {
            tmp.next=node2;
        }
        return virtualHead.next;
    }
    /**
     * 合并有序列表,递归写法
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
