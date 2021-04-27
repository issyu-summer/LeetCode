package cn.edu.xmu.leetcode.sword;

import java.util.HashMap;

/**
 * @author summer
 * @since  2021/3/1 10:54
 * @see <a href="https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/">重建二叉树</a>
 */
public class Main7 {


     //Definition for a binary tree node.
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    /**
     * 创建一颗二叉树
     */
    int [] pre;
    HashMap<Integer,Integer> dic=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       this.pre=preorder;
       //记录序号,只能适用于不重复的
       for (int i=0;i<inorder.length;i++){
           dic.put(inorder[i],i);
       }
       return recur(0,0,inorder.length-1);
    }
    TreeNode recur(int root,int left,int right){
        if(left>right){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[root]);
        int tmp=dic.get(pre[root]);
        //root+1为左子树的第一个元素，在前序中就是左子树根，left~tmp-1是左子树的长度
        treeNode.left=recur(root+1,left,tmp-1);
        //root+tmp-left+1为右子树第一个元素，在前序中就是右子树的根，tmp+1,right是右子树的长度
        treeNode.right=recur(root+tmp-left+1,tmp+1,right);
        return treeNode;
    }

    public static void main(String[] args) {
        int []pre=new int[]{
                3,9,20,15,7
        };
        int []in=new int[]{
                9,3,15,20,7
        };
        Main7 main7 = new Main7();
        main7.buildTree(pre,in);
    }
}
