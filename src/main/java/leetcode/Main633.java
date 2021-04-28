package leetcode;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/sum-of-square-numbers/">平方数之和</a><br/>
 * @since 2021/4/28 8:55
 */
public class Main633 {


    public boolean judgeSquareSum(int c) {
        int left=0,right= (int) Math.sqrt(c);
        while (left<=right){
            int tmp=left*left+right*right;
            if(tmp==c){
                return true;
            }
            if(tmp<c){
                left++;
            }
            if(tmp>c){
                right--;
            }
        }
        return false;
    }
}
