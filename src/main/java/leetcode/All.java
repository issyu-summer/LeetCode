package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author summer
 * @date 2021/3/18 22:57
 */
public class All {

    /**
     * 一维数组的动态和,直接使用动态规划
     */
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int []sum=new int[length];
        sum[0]=nums[0];
        for (int i=1;i<length;i++){
            sum[i]=sum[i-1]+nums[i];
        }
        return sum;
    }

    /**
     * 非递减数列
     */
    public boolean checkPossibility(int[] nums) {
        int tmp=nums[0];
        int size=nums.length;
        int n=0;
        for(int i=1;i<size;i++){
            if(tmp>nums[i]){
                n++;
            }
            tmp=nums[i];
        }
        return n<2;
    }

    /**
     * 1603
     * 设计停车系统
     */
    class ParkingSystem {

        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big=big;
            this.medium=medium;
            this.small=small;
        }

        public boolean addCar(int carType) {
            if(carType==1){
                if(big==0){
                    return false;
                }
                big--;
            }else if(carType==2){
                if(medium==0){
                    return false;
                }
                medium--;
            }else{
                if(small==0){
                    return false;
                }
                small--;
            }
            return true;
        }
    }

    /**
     * LCP 18
     * 早餐组合
     * 直接使用循环超出时间限制
     */
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int num=0;
        for (int j : staple) {
            for (int drink : drinks) {
                if (j + drink <= x) {
                    num++;
                }
            }
        }
        return num<1000000007?num:Math.floorMod(num,1000000007);
    }

    /**
     * LCP 18
     * 早餐组合
     * 有序双指针
     */
    public int breakfastNumber1(int[] staple, int[] drinks, int x) {
        int num=0;
        List<Integer> stapleList
                = Arrays.stream(staple).sorted().boxed().collect(Collectors.toList());
        List<Integer> drinksList
                = Arrays.stream(drinks).sorted().boxed().collect(Collectors.toList());
        int j=drinks.length-1;
        for(int i=0;i< staple.length;i++){
            while (j>=0&& stapleList.get(i) + drinksList.get(j) >x){
                j--;
            }
            if(j==-1){
                break;
            }
            num+=j+1;
            num=Math.floorMod(num,1000000007);
        }
        return num;
    }

}
