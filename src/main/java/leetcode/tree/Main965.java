package leetcode.tree;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/univalued-binary-tree/">单值二叉树</a><br/>
 * @since 2021/4/27 22:47
 */
public class Main965 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        return preOrder(root, root.val);
    }

    public boolean preOrder(TreeNode root,int tmp){
        if(root==null){
            return true;
        }
        if(tmp!=root.val){
            return false;
        }
        return preOrder(root.left,tmp)&&preOrder(root.right,tmp);
    }
}
