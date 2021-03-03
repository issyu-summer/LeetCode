package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.List;

/**
 * @author summer
 * @date 2021/3/1 19:53请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main12 {
    public boolean exist(char[][] board, String word) {
        char[] chars=word.toCharArray();
        return true;
    }

    public void dfs(char[][] board, char[] word, List<Character> dst, int i, int j, int level){
        //截至条件(完成，越界，怎么走都不是想要的)
       if(level==6||i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=word[level]){
           return;
       }
       level=0;
       for(i=0;i<board.length;i++){
           for(j=0;j<board[0].length;j++){
               char c=word[level+1];
               if(c==board[i-1][j]){
                   dst.add(board[i][j]);
                   dfs(board,word,dst,i-1,j,level+1);
               }else if(c==board[i+1][j]){
                   dst.add(board[i][j]);
                   dfs(board,word,dst,i+1,j,level+1);
               }else if(c==board[i][j-1]){
                   dst.add(board[i][j]);
                   dfs(board,word,dst,i,j-1,level+1);
               }else if(c==board[i][j+1]){
                   dst.add(board[i][j]);
                   dfs(board,word,dst,i,j+1,level+1);
               }else {
                   return;
               }
           }
       }

    }

    public boolean exist1(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }


}
