package leetcode.person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/5 15:51
 */
public class Main0 {
    public static int purchasePlans(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int num=0;
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]<=target){
                    num++;
                }
            }
        }
        return num>1000000007?Math.floorMod(num,1000000007):num;
    }

    /**
     * 双指针，List
     */
    public static int purchasePlans1(int[] nums, int target) {
        int num=0;
        List<Integer> list
                = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        int i=0,j=list.size()-1;
        while (i<j){
            if(list.get(i)+list.get(j)>target){
                j--;
            }else{
                num+=(j-i);
                i++;
            }
            //注意细节
            num%=1000000007;
        }
        return num;
    }

    /**
     * 双指针，ar
     */
    public static int purchasePlans2(int[] nums, int target) {
        int num=0;
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while (i<j){
            if(nums[i]+nums[j]>target){
                j--;
            }else{
                num+=(j-i);
                i++;
            }
            //注意细节
            num%=1000000007;
        }
        return num;
    }
    public static void main(String[] args) {
        int []ar=new int[]{
                2,5,3,5
        };
        System.out.println(purchasePlans1(ar,6));
    }
}
