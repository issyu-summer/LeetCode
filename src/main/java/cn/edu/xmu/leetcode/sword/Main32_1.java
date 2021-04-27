package cn.edu.xmu.leetcode.sword;

import javax.lang.model.element.QualifiedNameable;
import java.util.*;

/**
 * @author summer
 * @since  2021/3/7 21:36
 * @see <a href="https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/">从上到下打印树</a>
 */
public class Main32_1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 从左到右、用队列、先进先出
     */
    public int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node =queue.poll();
            list.add(node.val);
            if(node.left!=null) {
                queue.add(node.left);
            }
            if (node.right!=null) {
                queue.add(node.right);
            }
        }
        int []ar =new int[list.size()];
        for(int i=0;i<list.size();i++){
            ar[i]=list.get(i);
        }
        return ar;
        //return list.stream().mapToInt(Integer::intValue).toArray();
        //差距有三毫秒之大
    }
}
