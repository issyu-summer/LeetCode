package leetcode.sword;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/">构建乘积数组</a><br/>
 * @since 2021/4/7 23:38
 */
public class Main66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0){
            return a;
        }
        int length = a.length;
        int[] res = new int[length];
        res[0] = 1;
        //当前元素左边的所有元素乘积（不包含当前元素）
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        int right = 1;
        //right表示当前元素右边所有元素的乘积（不包含当前元素）,
        //res[i]表示的是左边的乘积，right是右边的乘积，他俩相乘就是
        //除了自己以外数组的乘积
        for (int i = length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= a[i];
        }
        return res;
    }
}
