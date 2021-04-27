package leetcode.array;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/xor-operation-in-an-array/"></a><br/>
 * @since 2021/4/25 14:49
 */
public class Main1486 {
    public int xorOperation(int n, int start) {
        int result=0;
        for (int i = 0; i < n; i++) {
            result^=(start+2*i);
        }
        return result;
    }
}
