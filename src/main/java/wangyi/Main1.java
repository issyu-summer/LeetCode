//package wangyi;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * @author summer
// * @see <a href=""></a><br/>
// * @since 2021/4/18 16:33
// */
//public class Main1 {
//
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
//
//    public ListNode solve (ListNode S) {
//        // write code here
//        ListNode cur=S;
//        int tmp= cur.val;
//        List<ListNode> list=new ArrayList<>();
//        ListNode tmpNode;
//        while (cur!=null){
//            if(tmp<cur.val){
//                list.add(cur);
//                tmp= cur.val;
//            }
//            cur=cur.next;
//        }
//    }
//}
