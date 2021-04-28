package leetcode.sword;

/**
 * @author summer
 * @since  2021/3/7 22:54
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/">二叉搜索树的后序遍历序列</a>
 */
public class Main33 {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    /**
     * 判断是不是二叉树搜索树的后续遍历：
     * 后续遍历的最后一个数字一定是根节点
     */
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j)
        {
            return true;
        }
        int p = i;
        while(postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while(postorder[p] > postorder[j])
        {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
