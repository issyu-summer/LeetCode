package cn.edu.xmu.leetcode.lcp;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/na-ying-bi/">拿硬币</a><br/>
 * @since 2021/4/8 12:15
 */
public class Main6 {

    /**
     * 位运算
     */
    public static int minCount(int[] coins) {
        int count=0;
        for(int n:coins){
            if(n%2==0){
                count+=n>>1;
            }else {
                count += ((n>>1) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minCount(new int[]{
                4,2,1
        }));
    }
}
