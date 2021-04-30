package leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author summer
 * @date 2021/3/17 22:04
 */
public class SlideWindow {


    /**
     * 数组中连续k个数的最大值
     */
    public int sumMax(int []nums,int k){
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int size = nums.length;
        int left=0;
        int tmp=sum;int max=sum;
        for(int i=k;i<size;i++){
            tmp=tmp+nums[i]-nums[left];
            max=Math.max(max,tmp);
            left+=1;
        }
        return max;
    }

    /**
     * 长度为k子串中,元音字母的最大个数
     */
    public int mostVowel(String s,int k){
        int length = s.length();
        int left=0;int right=k-1;
        String tmp;
        int num=0;int max=0;
        for(int i=0;i<length-k+1;i++){
            tmp=s.substring(left,right+1);
            num=this.containsVowel(tmp);
            max=Math.max(num,max);
            left++;right++;
        }
        return max;
    }

    /**
     * 是否包含元音字母
     */
    private int containsVowel(String s){
        int num=0;
        byte[] bytes = s.getBytes();
        for (byte aByte : bytes) {
            if (aByte == 'a' || aByte == 'e' || aByte == 'i' || aByte == 'o' || aByte == 'u') {
                num++;
            }
        }
        return num;
    }

    /**
     * 滑动窗口中的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size=nums.length;
        int left=0;int right=k-1;
        int max = nums[0];
        Queue<Integer> queue =new LinkedList<>();
        queue.add(max);
        while (right<size){
            for(int i=left;i<=right;i++){
                if(nums[i]>max){
                    max=nums[i];
                    queue.poll();
                    queue.add(max);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = {
                1, 3, -1, -3, 5, 3, 6, 7
        };
        SlideWindow slideWindow = new SlideWindow();
        System.out.println(slideWindow.sumMax(ints,3));

        String s="abciiidef";
        System.out.println(slideWindow.mostVowel(s,3));
    }
}
