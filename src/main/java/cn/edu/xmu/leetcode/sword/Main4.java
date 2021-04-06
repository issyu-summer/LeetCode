package cn.edu.xmu.leetcode.sword;

/**
 * @author summer
 * @date 2021/3/1 9:19
 * 🗡☞offer-2：
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:

 * 现有矩阵 matrix 如下：

 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * 给定target=20，返回false。
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
