package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see <a href="https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/">circule_remain</a>
 * @author summer
 * @since 2021/4/4 12:43
 */
public class Main62 {

    /**
     * @see <a href="https://blog.csdn.net/a_helloword/article/details/100048861">约瑟夫环问题</a> <br/>
     * 当最后弈一轮游戏结束时,胜利者的索引一定是0,index逆推,每次增加m个,越界时最大索引-1,重新index=0开始,直到进行n-1轮游戏即可。
     * dp[i]=(dp[i−1]+m)%i
     */
    public static int lastRemaining(int n, int m) {
        //从i=1,index=0开始,如果只有一个人,那么胜利的一定是index=0,如果有两个人,胜利的一定是index+m的那个人,依次类推
        int index=0;
        for(int i=2;i<=n;i++){
            //向后推m个剔除
            index=(index+m)%i;
        }
        //对于磁体来说,ar[index]=index;
        return index;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));
    }
}
