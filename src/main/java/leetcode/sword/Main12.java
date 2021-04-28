package leetcode.sword;

import java.util.List;

/**
 * @author summer
 * @since  2021/3/1 19:53
 * @see <a href="https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/">矩阵中的路径</a>
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
