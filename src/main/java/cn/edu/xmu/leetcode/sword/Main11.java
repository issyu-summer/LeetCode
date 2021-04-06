package cn.edu.xmu.leetcode.sword;

/**
 * @author summer
 * @date 2021/3/1 19:40
 * 11把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 */
public class Main11 {
    public static int minArray(int[] numbers) {
        int temp=numbers[0];
        int min=temp;
        for (int n:numbers
             ) {
            if(temp<=n){
                temp=n;
            }else {
                min=n;
                break;
            }
        }
        return min;
    }
}
