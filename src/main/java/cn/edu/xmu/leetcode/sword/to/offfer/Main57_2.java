package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author summer
 * @date 2021/3/8 11:44
 * 连续数字和等于target
 */
public class Main57_2 {

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
