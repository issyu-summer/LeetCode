package cn.edu.xmu.leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/">0～n-1中缺失的数字</a><br/>
 * @since 2021/4/7 23:16
 */
public class Main53 {
    /**
     * 暴力搜索
     */
    public static int missingNumber(int[] nums) {
        if(nums.length==1){
            if(nums[0]==0){
                return 1;
            }else {
                return 0;
            }
        }
        int x=0;
        for(int n:nums){
            if(n!=x++){
                return x-1;
            }
        }
        return nums.length;
    }

    /**
     * 二分法
     */
    public static int missingNumber1(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            //nus:0,1,2,3,4,6,7,8,9
            //ind:0,1,2,3,4,5,6,7,8
            //注意到,第一个出问题的是ind不正常的。
            if(nums[mid]==mid){
                //如果数字的位置正常,就慢慢向后找
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return l;
    }

    /**
     * 异或
     */
    public static int missingNumber2(int[] nums) {
        int length=nums.length;
        int ans=0;
        for(int i=0;i<length;i++){
            ans=ans^(i+1)^nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber2(new int[]{
                0,1,2,3,4,5,6,7,8,9,11
        }));
    }
}
