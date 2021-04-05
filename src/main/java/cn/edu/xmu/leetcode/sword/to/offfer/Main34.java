package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author summer
 * @date 2021/3/7 22:56
 */
public class Main34 {

      //Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        static List<List<Integer>> lists =new LinkedList<>();
        static LinkedList<Integer> list=new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
            dfs(root,sum);
            return lists;
        }

        static void dfs(TreeNode root, int target){
            //截至条件
            if(root==null){
                return;
            }
            target-=root.val;
            list.add(root.val);
            if(target==0&&root.left==null&&root.right==null){
                lists.add(list);
            }
            //有可能还会有剪枝
            dfs(root.left,target);
            dfs(root.right,target);
            //回溯
            list.removeLast();
        }

    public static void main(String[] args) {
        TreeNode treeNode =new TreeNode(5);
        TreeNode treeNode1 =new TreeNode(4);
        TreeNode treeNode2 =new TreeNode(8);
        TreeNode treeNode3 =new TreeNode(11);
        TreeNode treeNode4 =new TreeNode(13);
        TreeNode treeNode5 =new TreeNode(4);
        TreeNode treeNode6 =new TreeNode(7);
        TreeNode treeNode7=new TreeNode(2);
        TreeNode treeNode8 =new TreeNode(5);
        TreeNode treeNode9 =new TreeNode(1);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode5.left=treeNode8;
        treeNode5.right=treeNode9;
        pathSum(treeNode,22);
    }
}

