package leetcode.tree;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/same-tree/">相同的树</a><br/>
 * @since 2021/4/30 13:14
 */
public class Main100 {
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
     * dfs
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }

    public boolean dfs(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null||p.val!=q.val){
            return false;
        }
        return dfs(p.left,q.left)&&dfs(p.right,q.right);
    }

}
