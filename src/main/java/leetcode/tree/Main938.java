package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/range-sum-of-bst/">二叉搜索树的范围和</a><br/>
 * @since 2021/4/27 10:39
 */
public class Main938 {

    public static class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
    }

    private int sum=0;
    public  int rangeSumBST0(TreeNode root, int low, int high) {
        inOrder0(root,low,high);
        return sum;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        //根比high大、则所有的右子树都比high大
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        //根比low小、则所有的左子树都比low小
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        //经过两个if后的root是符和条件的
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


    /**
     * 可以考虑在遍历中求和
     */
    public  void inOrder0(TreeNode root,int low,int high){
        if(root==null){
            return;
        }
        inOrder0(root.left,low,high);
        if(root.val>=low&&root.val<=high){
            sum+=root.val;
        }
        inOrder0(root.right,low,high);
    }

    /**
     * 将中序遍历（升序）表示成一个列表
     */
    public void inOrder(List<Integer> list,TreeNode root){
        if(root==null){
            return;
        }
        inOrder(list,root.left);
        list.add(root.val);
        inOrder(list,root.right);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        TreeNode node1=new TreeNode(5);
        TreeNode node2=new TreeNode(15);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(7);
        TreeNode node5=new TreeNode(18);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.right=node5;
        Main938 main938=new Main938();
        System.out.println(main938.rangeSumBST(root,7, 15));
    }

}
