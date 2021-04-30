package leetcode.hot;

import java.util.LinkedList;
import java.util.List;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">二叉树的最大深度</a><br/>
 * @since 2021/4/7 0:31
 */
public class Main104 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * DFS,快
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * BFS,慢
     */
    public int maxDepth1(TreeNode root) {
        if(root==null){
            return 0;
        }
        //表示每层
        List<TreeNode> list=new LinkedList<>(){
            {add(root);}
        };
        int depth=0;
        while (!list.isEmpty()){
            //临时储存当前层的下一层
            List<TreeNode> tmp=new LinkedList<>();
            for(TreeNode treeNode:list){
                if(treeNode.left!=null){
                    tmp.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    tmp.add(treeNode.right);
                }
            }
            depth++;
            //向下一层
            list=tmp;
        }
        return depth;
    }
}
