package leetcode.array;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/word-search/">单词搜索</a><br/>
 * @since 2021/4/27 11:09
 */
public class Main79 {

    public boolean exist(char[][] board, String word) {
        int h= board.length,w=board[0].length;
        boolean [][] visited=new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag=dfsBackTrace(board,visited,i,j,word,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsBackTrace(
            char [][]board,boolean[][]visited,int i,int j,String s,int k){
        //如果首个字符不匹配,直接返回false
        if(board[i][j]!=s.charAt(k)){
            return false;
        }
        //已经全部匹配，返回true
        if(k==s.length()-1){
            return true;
        }
        //标识board[i][j]已经被访问过了
        visited[i][j]=true;
        //标识着上下左右四个方向
        int [][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        boolean result=false;
        for (int []dir:directions) {
            int newi=i+dir[0],newj=j+dir[1];
            //如果没有越界、可以考虑程设计为一个方法
            if(newi>=0&&newi< board.length&&newj>=0&&newj<board[0].length){
                //且当前字符们没有被访问过
                if(!visited[newi][newj]){
                    boolean flag=dfsBackTrace(board,visited,newi,newj,s,k+1);
                    if(flag){
                        result=true;
                        break;
                    }
                }
            }
        }
        //回溯
        visited[i][j]=false;
        return result;
    }
}
