package leetcode.hot;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/majority-element/">多数元素</a><br/>
 * @since 2021/4/7 0:46
 */
public class Main169 {

    /**
     * 摩尔投票,也可以用来找众数
     */
    public static int majorityElement(int[] nums) {
        int count=1;
        int candidate=nums[0];
        for(int n:nums){
            if(candidate==n){
                count++;
            }else {
                count--;
            }
            if(count==0){
                candidate=n;
                count=1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{
                3,2,3
        }));
    }
}
