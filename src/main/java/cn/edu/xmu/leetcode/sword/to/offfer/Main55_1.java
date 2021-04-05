package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author summer
 * @date 2021/3/19 11:22
 */
public class Main55_1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 二叉树的深度,DFS遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归,左右子树较大的+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 二叉树的深度,BFS遍历、
     * 利用LinkedList来暂存节点,进行广度遍历
     * BFS远远慢于DFS,但不需要递归,但使用的内存比DFS少
     */
    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=0;
        List<TreeNode> queue=new LinkedList<>(){{add(root);}},tmp;
        while (!queue.isEmpty()){
            tmp=new LinkedList<>();
            for(TreeNode node:queue){
                if(node.left!=null){
                    tmp.add(node.left);
                }
                if(node.right!=null){
                    tmp.add(node.right);
                }
            }
            queue=tmp;
            depth++;
        }
        return depth;
    }
}
