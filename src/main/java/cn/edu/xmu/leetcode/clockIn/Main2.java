package cn.edu.xmu.leetcode.clockIn;

import java.util.Arrays;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/merge-sorted-array/">合并两个有序数组</a><br/>
 * @since 2021/4/6 10:20
 */
public class Main2 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,x=0;
        int []ar=new int[m+n];
        while (i!=m&&j!=n){
            if(nums1[i]<=nums2[j]){
                ar[x++]=nums1[i];
                i++;
            }else {
                ar[x++]=nums2[j];
                j++;
            }
        }
        //数组1有剩余
        if(i!=m){
            for(int a=i;a<m;a++){
                ar[x++]=nums1[a];
            }
        }
        //数组2有剩余
        if(j!=n){
            for(int a=j;a<n;a++){
                ar[x++]=nums2[a];
            }
        }
        if (m + n >= 0) {
            System.arraycopy(ar, 0, nums1, 0, m + n);
        }

    }

    public static void main(String[] args) {
        int []nums1=new int[]{
                1,2,3,0,0,0
        };
        int [] nums2=new int[]{
                2,5,6
        };
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
