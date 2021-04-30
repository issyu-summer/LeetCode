package leetcode.sword;

/**
 * @author summer
 * @since  2021/3/1 19:53
 * @see <a href="https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/">矩阵中的路径</a>
 */
public class Main12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,words,new boolean[board.length][board[0].length],i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 标准的dfs写法
     */
    public boolean dfs(char[][] board,char[]word,boolean[][]visited,int i,int j,int level){
        if(i<0||i>=board.length||j<0||j>=board[0].length||word[level]!=board[i][j]){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        if(level==word.length-1){
            return true;
        }
        visited[i][j]=true;
        //此处没有双重for循环,因为对于任意一个字符来说,最多只有4个方向
        boolean res=dfs(board,word,visited,i+1,j,level+1)||dfs(board, word, visited, i-1, j, level+1)
                ||dfs(board, word, visited, i, j+1, level+1)||dfs(board, word, visited, i, j-1, level+1);
        visited[i][j]=false;
        return res;
    }

    /**
     * 优化的dfs<br/>
     * 考虑到、words中不会有’\0‘.所以将visited合并到word[level]!=board[i][j]
     */
    public boolean dfsOptimized(char[][] board,char[]word,int i,int j,int level){
        if(i<0||i>=board.length||j<0||j>=board[0].length||word[level]!=board[i][j]){
            return false;
        }
        if(level==word.length-1){
            return true;
        }
        board[i][j]='\0';
        //此处没有双重for循环,因为对于任意一个字符来说,最多只有4个方向
        boolean res=dfsOptimized(board,word,i+1,j,level+1)||dfsOptimized(board, word, i-1, j, level+1)
                ||dfsOptimized(board, word, i, j+1, level+1)||dfsOptimized(board, word,i, j-1, level+1);
        board[i][j]=word[level];
        return res;
    }

}
