package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">验证二叉搜索树</a><br/>
 * @since 2021/4/30 12:18
 */
public class Main98 {

    public static class TreeNode {
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
     * method1<br/>
     * 使用dfs
     */
    public  boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    /**
     * dfs、把我绕晕了<br/>
     * 对于左子树、不必关心smaller。<br/>
     * 对于右子树、不必关心bigger.<br/>
     */
    public  boolean dfs(TreeNode root,long smaller,long bigger){
      if(root==null){
          return true;
      }
      if(root.val<=smaller||root.val>=bigger){
          return false;
      }
        return dfs(root.left,smaller,root.val)&&dfs(root.right,root.val,bigger);
    }


    /**
     * method2<br/>
     * 使用二叉树的性质
     */
    public  boolean isValidBST1(TreeNode root) {
        last=Integer.MIN_VALUE;
        return inOrderOptimized(root);
    }
    /**
     * 二叉搜索树的中序遍历是升序
     */
    private long last;
    public boolean inOrderOptimized(TreeNode root){
        if(root==null){
            return true;
        }
        boolean l=inOrderOptimized(root.left);
        if(root.val<=last){
            return false;
        }
        last=root.val;
        boolean r=inOrderOptimized(root.right);
        return l&&r;
    }

    /**
     * method3
     * 效率低、<br/>
     * 在递归内部检查可以提高效率、<br/>
     * 并不需要把中序遍历的序列列出来<br/>
     */
    private List<Integer> list;
    public  boolean isValidBST2(TreeNode root) {
        list=new ArrayList<>();
        inOrder(root);
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public  void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
