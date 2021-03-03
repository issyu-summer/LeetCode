package cn.edu.xmu.leetcode.sword.to.offfer;

/**
 * @author summer
 * @date 2021/3/1 10:54
 *
 * 7-输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Main7 {


     //Definition for a binary tree node.
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    /**、
     * 创建一颗二叉树
     */

    public void createTree(TreeNode root,int [] ar,int i){
        root = new TreeNode(ar[0]);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return null;
    }
}
