package leetcode.sword;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/">和为s的连续正数序列</a><br/>
 * @author summer
 * @since  2021/3/8 11:44
 */
public class Main57_2 {

    /**
     * 滑动窗口（双指针）
     */
    public int[][] findContinuousSequence(int target) {
        int i=1,j=2,sum=3;
        List<int []> list=new LinkedList<>();
        while (i<j){
            if(sum==target){
                int []ar =new int[j-i+1];
                for(int a=i;a<=j;a++){
                    ar[a-i]=a;
                }
                list.add(ar);
            }
            if(sum>=target){
                sum-=i;
                i++;
            }else {
                j++;
                sum+=j;
            }
        }
        return list.toArray(new int [0][]);
    }

}
