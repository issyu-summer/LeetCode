package leetcode.data_structure;

import java.util.List;

/**
 * 链表
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/5/1 10:48
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 从数组构建链表
     */
    public static ListNode getList(int []ar){
        ListNode virtualHead=new ListNode();
        ListNode head=virtualHead;
        for (int n:ar
             ) {
            head.next= new ListNode(n);
            head=head.next;
        }
        return virtualHead.next;
    }

    /**
     * 从集合构建链表
     */
    public static ListNode getList(List<Integer> list){
        ListNode virtualHead=new ListNode();
        ListNode head=virtualHead;
        for (int n:list
        ) {
            head.next= new ListNode(n);
            head=head.next;
        }
        return virtualHead.next;
    }

    /**
     * 链表长度
     */
    public static int length(ListNode head){
        int length=0;
        while (head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
}
