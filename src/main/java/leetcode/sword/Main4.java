package leetcode.sword;

/**
 * @author summer
 * @since  2021/3/1 9:19
 * @see <a href="https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/">二维数组中的查找</a>
 */
public class Main4 {

    /**
     * 暴力搜索
     */
    public boolean findnumberin2Darray0(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            for (int j:ints) {
                if (target == j) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用递增的特点，从右上角开始，向左下角搜索，最多n+m次
     */
    public boolean findnumberin2Darray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
       int rows = matrix.length, columns = matrix[0].length;
       int i = 0, j = columns - 1;
       while (i<rows&&j>=0){
           int num=matrix[i][j];
               if(matrix[i][j]>target){
                   j--;
               }else if(matrix[i][j]<target){
                   i++;
               }else {
                   return true;
               }
           }
        return false;
    }
}
