package leetcode.dp;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum/">最小路径和</a><br/>
 * @since 2021/4/29 17:13
 */
public class Main64 {

    public static void main(String[] args) {
        int [][]gird=new int[][]{
                {1,3,1},{4,2,1},{1,5,1}
        };

        Main64 main64=new Main64();
        System.out.println(main64.minPathSum(gird));
    }

    /**
     * DP
     */
    public int minPathSum(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int [][]path=new int[row][col];
        path[0][0]=grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i==0&&j==0){
                    continue;
                }
                //推导方向为：<-------
                if(i==0){
                    path[i][j]=grid[i][j]+path[i][j-1];
                } else if(j==0){
                    path[i][j]=grid[i][j]+path[i-1][j];
                } else  {
                    path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
                }
            }
        }
        return path[row-1][col-1];
    }
}
