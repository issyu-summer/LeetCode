package cn.edu.xmu.leetcode.Tree;

import java.util.Stack;

/**
 * @author summer
 * @date 2021/3/18 18:46
 */
public class Tree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 二叉树的镜像1
     * 递归
     */
    public TreeNode mirrorTree1(TreeNode root) {
        if(root==null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left=mirrorTree1(root.right);
        root.right=mirrorTree1(tmp);
        return root;
    }

    /**
     * 二叉树的镜像2
     * 使用栈,栈可以用来交换两个顺序
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if(root==null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>(){{add(root);}};
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null) {
                stack.push(node.right);
            }
            TreeNode tmp=node.left;
            node.left=node.right;
            node.right=tmp;
        }
        return root;
    }
}
