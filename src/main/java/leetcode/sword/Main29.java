package leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/">顺时针打印矩阵</a><br/>
 * @date 2021/3/19 12:24
 */
public class Main29 {

    /**
     * 牛皮plus<br/>
     * 每次从左向右打印后,接下应该从上向下打印,此时上边界应该向下（++t）<br/>
     * 每次从上向下打印后,接下应该从右向左打印,此时右边界应该向左（--r）<br/>
     * 每次从右向左打印后,接下应该从下向上打印,此时下边界应该向上（--b）<br/>
     * 每次从下向上打印后,接下应该从左向右打印,此时左边界应该向右（++l）<br/>
     */
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if(++t > b) {
                break;
            }
            for(int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if(l > --r) {
                break;
            }
            for(int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if(t > --b) {
                break;
            }
            for(int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if(++l > r) {
                break;
            }
        }
        return res;
    }

}
