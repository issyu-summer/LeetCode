package leetcode.dp;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/unique-binary-search-trees/">不同的二叉搜索树</a><br/>
 * @since 2021/4/29 17:38
 */
public class Main96 {

    /**
     * count[i]:长度为i的序列构成的二叉搜索树的长度<br/>
     * tmp[j,i]:以j为根,长度i的序列构成的二叉搜索树的长度<br/>
     * count[n]=tmp[1,n]+tmp[2,n]+tmp[3,n]+...+tmp[n,n]=∑tmp[j,n]  j=1~n<br/>
     * tmp[j,i]以j为根；<br/>
     *  &nbsp;&nbsp;&nbsp;&nbsp;则左子树为1,2,3,...,j-1、能够构成的子树数量为count[j-1]<br/>
     *  &nbsp;&nbsp;&nbsp;&nbsp;则右子树为j+1,j+2,...,i、能够构成的子树数量为count[i-j]<br/>
     *  &nbsp;&nbsp;&nbsp;&nbsp;总的组合数为count[j-1]*count[i-j]<br/>
     * 所以count[n]<br/>
     * =count[1-1]*count[n-1]+count[2-1]*count[n-2]+...+count[n-1]*count[n-n]<br/>
     * =∑count[j-1]*count[n-j]  j=1~n
     **/
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                //构成二叉搜索树的个数仅仅于长度有关
                count[i] += count[j - 1] * count[i - j];
            }
        }
        return count[n];
    }

}
