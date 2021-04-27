package leetcode.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/">两数之和 IV - 输入 BST</a><br/>
 * @since 2021/4/27 22:54
 */
public class Main653 {

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

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        return inOrder(root,set,k);
    }

    public boolean inOrder(TreeNode root,Set<Integer> set,int k){
        if(root==null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return inOrder(root.left,set,k)||inOrder(root.right,set,k);
    }
}
