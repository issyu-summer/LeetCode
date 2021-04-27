package leetcode.array;

/**
 * 无意义的题目
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/three-consecutive-odds/">存在连续三个奇数的数组</a><br/>
 * @since 2021/4/26 10:38
 */
public class Main1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length-2; i++) {
            int tmp=arr[i];
            if(tmp%2!=0){
                int n=arr[i+1];
                int next=arr[i+2];
                if(n%2!=0&&next%2!=0){
                    return true;
                }
            }
        }
        return false;
    }
}
