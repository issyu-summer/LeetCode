package leetcode.tree;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/subtree-of-another-tree/">另一个树的子树</a><br/>
 * @since 2021/4/27 23:04
 */
public class Main572 {

    //子结构和子树不一样？
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


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null||t==null){
            return false;
        }
        return inOrder(s,t)||inOrder(s.left,t)||inOrder(s.right,t);
    }

    public boolean inOrder(TreeNode a,TreeNode b){
        if(b==null){
            return true;
        }
        if(a==null||a.val!=b.val){
            return false;
        }
        return inOrder(a.left,b.left)&&inOrder(a.right,b.right);
    }

}
