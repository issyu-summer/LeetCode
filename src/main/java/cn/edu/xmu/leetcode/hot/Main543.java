package cn.edu.xmu.leetcode.hot;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/diameter-of-binary-tree/">二叉树的直径</a><br/>
 * @since 2021/4/7 0:53
 */
public class Main543 {

    public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;this.right = right;
      }
  }

    private int ans=0;
    /**
     * 需要计算所有子树的深度并比较
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
       return ans-1;
    }
    private int depth(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        //记录每个子树的深度
        int l=depth(treeNode.left);
        int r=depth(treeNode.right);
        ans=Math.max(l+r+1,ans);
        //还是需要的不然没办法算子树的深度，List<Integer> depthList.add(l).add(r)
        return Math.max(l,r)+1;
    }
}
