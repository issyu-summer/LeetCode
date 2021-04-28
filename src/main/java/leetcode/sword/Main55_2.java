package leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/">平衡二叉树</a><br/>
 * @since 2021/4/5 10:58
 */
public class Main55_2 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * <ul>
     *     <li>左右子树深度差不超过1</li>
     *     <li>左子树、右子树也是平衡二叉树</li>
     * </ul>
     */
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(depth(root.left)-depth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    /**
     * 二叉树的深度
     */
    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(depth(node.right),depth(node.left))+1;
    }
}
