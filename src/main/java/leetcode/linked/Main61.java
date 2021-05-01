package leetcode.linked;

import leetcode.data_structure.ListNode;

import java.util.List;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/rotate-list/"> 旋转链表</a><br/>
 * @since 2021/5/1 10:48
 */
public class Main61 {

    /**
     * 神之一手、使用1个指针代替了快慢双指针。
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n=1;
        ListNode fast=head;
        while (fast.next!=null){
            fast=fast.next;
            n++;
        }
        int add=n-n%k;
        if(add==n){
            return head;
        }
        fast.next=head;
        while (add-->0){
            fast=fast.next;
        }
        head=fast.next;
        fast.next=null;
        return head;
    }


    /**
     * 快慢双指针
     */
    public ListNode rotateRight0(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int len=length(head);
        k = k%len;
        ListNode slow=head,fast=head;
        for (int i = 0; i < k; i++) {
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        fast.next=head;
        head=slow.next;
        slow.next=null;
        return head;
    }

    private int length(ListNode head){
        int length=0;
        while (head!=null){
            length++;
            head=head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Main61 main61=new Main61();
        main61.rotateRight(ListNode.getList(new int[]{
                1,2,3,4,5
        }),2);
    }
}
