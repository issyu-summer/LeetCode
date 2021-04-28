package leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/">二叉搜索树的最近公共祖先</a><br/>
 * @since 2021/4/27 22:31
 */
public class Main68_1 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * p\q一定在树中、最近公共祖先也一定在数中
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果p、q在树的左侧，则最公共祖先也在树左侧
        if(p.val< root.val&&q.val< root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        //同理、最近难公共祖先在树的右侧
        if(p.val> root.val&&q.val> root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //如果在树的两侧、则树根为最近公共组线
        return root;
    }
}
