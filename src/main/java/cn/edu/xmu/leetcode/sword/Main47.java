package cn.edu.xmu.leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/">礼物的最大价值</a><br/>
 * @since 2021/4/8 12:22
 */
public class Main47 {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //第一行只能，连续向左
        for(int j = 1; j < n; j++) {
            // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        }
        //第一列只能，连续向右
        for(int i = 1; i < m; i++) {
            // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        }
        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
