package leetcode.sword;

/**
 * @author summer
 * @since  2021/3/1 19:40
 * @see <a href="https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/">旋转数组的最小数字</a>
 */
public class Main11 {
    public static int minArray(int[] numbers) {
        int temp=numbers[0];
        int min=temp;
        for (int n:numbers
             ) {
            if(temp<=n){
                temp=n;
            }else {
                min=n;
                break;
            }
        }
        return min;
    }

    public static int minArray1(int [] numbers){
        int l=0,r=numbers.length-1;
        while (l<r){
            int mid=l+((r-l)>>1);
            if(numbers[mid]<numbers[r]){
                r=mid;
            }else if(numbers[mid]==numbers[r]){
                r--;
            }else if(numbers[mid]>numbers[r]){
                l=mid+1;
            }
        }
        return numbers[l];
    }
}
