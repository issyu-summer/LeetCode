package leetcode.array;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.HashSet;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/25 15:03
 */
public class Main217 {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int n: nums
             ) {
            if(!set.add(n)){
                return true;
            }
        }
        return false;
    }
}
