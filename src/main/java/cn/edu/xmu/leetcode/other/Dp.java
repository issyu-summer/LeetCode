package cn.edu.xmu.leetcode.other;

/**
 * @author summer
 * @date 2021/3/18 23:08
 */
public class Dp {
    /**
     * 最小花费爬楼梯
     */
    public int minCostClimbingStairs(int[] cost) {
        return 0;
    }

    /**
     * 判断s是否为t的子序列
     */
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        return true;
    }

    /**
     * 最长公共子序列的长度
     */
    public int lcs(String s,String t){
        int sSize=s.length();
        int tSize=t.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int [][]lcs=new int[sSize+1][tSize+1];
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=1;i<sSize+1;i++){
            for(int j=1;j<tSize+1;j++){
               if(sChars[i-1]==tChars[j-1]){
                    lcs[i][j]=lcs[i-1][j-1]+1;
                    //长度对了，字符串不对
                   stringBuilder.append(sChars[i - 1]);
               }else {
                    lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        System.out.println(stringBuilder);
        return lcs[sSize][tSize];
    }

    public static void main(String[] args) {
        Dp dp = new Dp();
        System.out.println(dp.lcs("ABCB","BDCA"));
    }
}
