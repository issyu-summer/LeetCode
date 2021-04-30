package leetcode.tree;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/path-sum/">路径总和</a><br/>
 * @since 2021/4/30 13:19
 */
public class Main112 {

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
     * dfs<br/>
     * 从target倒推
     */
    public boolean hasPathSum0(TreeNode root, int targetSum) {
        return dfs(root,targetSum);
    }

    public boolean dfs(TreeNode root,int target){
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return target==root.val;
        }
        return dfs(root.left,target-root.val)||dfs(root.right,target-root.val);
    }

    /**
     * dfs<br/>
     * 从0正推
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return myDfs(root,targetSum,0);
    }

    public boolean myDfs(TreeNode root,int target,int sum){
        if(root==null){
            return false;
        }
        sum+=root.val;
        if(root.left==null&&root.right==null){
            if(sum==target){
                return true;
            }
        }
        return myDfs(root.left,target,sum)||myDfs(root.right,target,sum);
    }

}
