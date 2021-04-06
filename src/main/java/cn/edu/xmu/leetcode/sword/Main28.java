package cn.edu.xmu.leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/">对称的二叉树</a><br/>
 * @since 2021/4/6 11:17
 */
public class Main28 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 值得一提的是,对称的二叉树中序遍历也对称
     */
    public boolean isSymmetric(TreeNode root) {
        //是否对称和根节点无关
        return root == null || recur(root.left, root.right);
    }
    private boolean recur(TreeNode l,TreeNode r){
        if(l==null&&r==null){
            return true;
        }
        if(l==null||r==null||l.val!=r.val){
            return false;
        }
        return recur(l.left,r.right)&&recur(l.right,r.left);
    }
}
