package cn.edu.xmu.leetcode.sword;

import java.util.*;

/**
 * @author summer
 * @date 2021/3/7 22:11
 */
public class Main32_3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    //使用2的bfs，然后根据层数加一个逆序
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list=new ArrayList<>();
        int i=1;
        while (!queue.isEmpty()){
            List<Integer> tmp=new ArrayList<>();
            for (int j=queue.size()-1;j>=0;j--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                    if (node.right != null) {
                        queue.add(node.right);
                    }

            }
            if(i%2==0) {
                Collections.reverse(tmp);
            }
            list.add(tmp);
            i++;
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
        List<List<Integer>> list = levelOrder(treeNode);
        list.forEach(e->e.forEach(System.out::println));
    }
}
