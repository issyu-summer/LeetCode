package cn.edu.xmu.leetcode.sword;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/">二叉搜索树的第k大节点</a><br/>
 * @author summer
 * @since  2021/3/19 11:41
 */
public class Main54 {

    /**
     * 核心：二叉搜索树的中序遍历是递减序列
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    /**
     * 54
     * 二叉搜索树的第k大节点
     * 遍历完
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        inorderRecur(root,list);
        int size=list.size();
        return list.get(size-k);
    }

    public void inorderRecur(TreeNode root, List<Integer> inorderList){
        if(root==null){
            return;
        }
        inorderRecur(root.left,inorderList);
        inorderList.add(root.val);
        inorderRecur(root.right,inorderList);
    }

    /**
     * 54
     * 二叉搜索树的第k大节点
     * 不用遍历完
     */
    static int res;
    static int k=1;
    public static void inorderRecur(TreeNode root){
        if(root==null){
            return;
        }
        inorderRecur(root.right);
        //提前结束递归
        if(k==0){
            return;
        }
        if(--k==0){
            res=root.val;
        }
        inorderRecur(root.left);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(4);
        TreeNode n3=new TreeNode(2);
        root.left=n1;root.right=n2;
        n1.right=n3;
        inorderRecur(root);
        System.out.println(res);

    }
}
