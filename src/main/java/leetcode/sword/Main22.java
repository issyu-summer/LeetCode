package leetcode.sword;

/**
 * @author summer
 * @since  2021/3/3 15:40
 * @see <a href="https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">链表中倒数第k个节点</a>
 */
public class Main22 {

      //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
              val = x;
          }

            //使用双指针
          public static ListNode getKthFromEnd(ListNode head, int k) {
              if (head == null) {
                  return null;
              }
              if (head.next == null) {
                  return head;
              }
              ListNode front=head;
              ListNode behind=head;
              for(int i=0;i<k;i++){
                  front=front.next;
              }
              while (front!=null){
                  front=front.next;
                  behind=behind.next;
              }
              return behind;
          }

          //设置标志,停留k次，正好走size-k次
          public ListNode getKthFromEnd1(ListNode head, int k) {
              ListNode pre = head;
              ListNode curr = head;
              while(curr!=null){
                  curr = curr.next;
                  if(k>0)
                      k--;
                  else{
                      pre = pre.next;
                  }
              }
              return pre;
          }

          public static void main(String[] args) {
              ListNode node1 = new ListNode(1);
              ListNode node2 = new ListNode(2);
              ListNode node3 = new ListNode(3);
              ListNode node4 = new ListNode(4);
              ListNode node5 = new ListNode(5);


              node1.next = node2;
              node2.next=node3;
              node3.next=node4;
              node4.next=node5;
              ListNode listNode=getKthFromEnd(node1, 1);
              System.out.println();
          }
      }
}
