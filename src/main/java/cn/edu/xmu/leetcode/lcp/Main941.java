package cn.edu.xmu.leetcode.lcp;

import java.util.Stack;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/valid-mountain-array/">有效的山脉数组</a><br/>
 * @since 2021/4/26 10:05
 */
public class Main941 {
    public boolean validMountainArray(int[] arr) {
        int length=arr.length;
        int i=0;
        //递增找峰值、递减找低谷的下标
        while (i<length-1&&arr[i]<arr[i+1]){
            i++;
        }
        if(i==0||i==length-1){
            return false;
        }
        while (i<length-1&&arr[i]>arr[i+1]){
            i++;
        }
        return i==length-1;
    }
}
