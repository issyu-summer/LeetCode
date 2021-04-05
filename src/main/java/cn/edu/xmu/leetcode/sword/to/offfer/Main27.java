package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.Stack;

/**
 * @author summer
 * @date 2021/3/7 23:35
 * 二叉树的镜像
 */
public class Main27 {

     //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        public TreeNode mirrorTree(TreeNode root) {
            if(root == null) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<>(){{add(root);}};
            TreeNode tmp=null;
            while (!stack.isEmpty()){
                TreeNode node=stack.pop();
                if(node.left!=null){
                    stack.push(node.left);
                }
                if(node.right!=null){
                    stack.push(node.right);
                }
                tmp=node.left;
                node.left=node.right;
                node.right=tmp;
            }
            return root;
        }
}
