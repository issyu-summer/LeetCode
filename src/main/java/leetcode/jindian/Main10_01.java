package leetcode.jindian;

import java.util.Arrays;

/**
 * 双指针
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/sorted-merge-lcci/">合并排序的数组</a><br/>
 * @since 2021/4/26 11:06
 */
public class Main10_01 {

    public void merge(int[] A, int m, int[] B, int n) {
        int i=0,j=0;
        int [] ret=new int[m+n];
        int temp=0;
        while (temp!=m+n-1&&(i<m&&j<n)){
            if (A[i] < B[j]) {
                ret[temp++]=A[i++];
            }else {
                ret[temp++]=B[j++];
            }
        }
        if(i!=m){
            for (int k = i; k <m ; k++) {
                ret[temp++]=A[k];
            }
        }
        if(j!=n){
            for (int k = j; k < n; k++) {
                ret[temp++]=B[k];
            }
        }
        System.arraycopy(ret, 0, A, 0, ret.length);
    }

    public static void main(String[] args) {
        Main10_01 main10_01=new Main10_01();
        int [] A={
                1,2,3,0,0,0
        };
        main10_01.merge(A,3,new int[]{
                2,5,6
        },3);
        System.out.println(Arrays.toString(A));
    }

}
