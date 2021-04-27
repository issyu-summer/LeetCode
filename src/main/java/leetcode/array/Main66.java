package leetcode.array;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/plus-one/"></a><br/>
 * @since 2021/4/25 14:31
 */
public class Main66 {

    public int[] plusOne(int[] digits) {
        int length =digits.length,tmp;
        for (int i = length-1; i >=0; i--) {
           digits[i]++;
           digits[i]%=10;
           if(digits[i]!=0){
               return digits;
           }
        }
        int [] nums=new int[digits.length+1];
        nums[0]=1;
        return nums;
    }
}
