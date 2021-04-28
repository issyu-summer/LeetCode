package leetcode.sword;

import java.util.Stack;

/**
 * @author summer
 * @since  2021/3/7 23:35
 * @see <a href="https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/">二叉树的镜像</a>
 */
public class Main27 {

     //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 辅助栈
     */
    public TreeNode mirrorTree(TreeNode root) {
            if(root == null) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<>(){{add(root);}};
            TreeNode tmp;
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


    /**
     * DFS
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

}
