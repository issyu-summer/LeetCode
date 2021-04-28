package leetcode.sword;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author summer
 * @since  2021/3/8 12:10
 */
public class Main59_1 {

    /**
     * 复杂度较高、
     */
    public int[] maxSlidingWindow0(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        int i=0,j=k-1,max=-1;
        for(int tmp=0;tmp<nums.length-k;tmp++){
            for(int temp=i;temp<=j;temp++){
                max= Math.max(nums[temp + tmp], max);
            }
            list.add(max);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 考虑使用非严格递减队列降低复杂度
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0, j = 1 - k; i < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(j > 0 && deque.peekFirst() == nums[j - 1]) {
                deque.removeFirst();
            }
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            // 记录窗口最大值
            if(j >= 0) {
                res[j] = deque.peekFirst();
            }
        }
        return res;
    }
}
