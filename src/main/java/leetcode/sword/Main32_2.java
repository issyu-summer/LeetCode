package leetcode.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author summer
 * @date 2021/3/7 20:54
 * 从左到右边打印节点 每层一行，bfs循环
 */
public class Main32_2 {
      //Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    /**
     * 从上到下
     */
        public static List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) {
                return null;
            }
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            List<List<Integer>> list=new ArrayList<>();
            while (!queue.isEmpty()){
                List<Integer> tmp=new ArrayList<>();
                //把该层打印完
                for (int i=queue.size()-1;i>=0;i--){
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                }
                list.add(tmp);
            }
            return list;
        }


    public static void main(String[] args) {

        TreeNode treeNode =new TreeNode(3);
        TreeNode treeNode1=new TreeNode(9);
        TreeNode treeNode2=new TreeNode(20);
        TreeNode treeNode3=new TreeNode(15);
        TreeNode treeNode4=new TreeNode(7);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode2.left=treeNode3;
        treeNode2.right=treeNode4;
        levelOrder(treeNode);
        System.out.println();
    }

}
