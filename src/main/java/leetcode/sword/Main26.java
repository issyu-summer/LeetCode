package leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/">树的子结构</a><br/>
 * @since 2021/4/13 9:57
 */
public class Main26 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    /**
     * 先序遍历
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null){
            return false;
        }
        return preRecur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    public boolean preRecur(TreeNode a,TreeNode b){
        if(b==null){
            return true;
        }
        if(a==null){
            return false;
        }
        if(a.val!=b.val){
            return false;
        }
        return preRecur(a.left,b.left)&&preRecur(a.right,b.right);
    }
}
