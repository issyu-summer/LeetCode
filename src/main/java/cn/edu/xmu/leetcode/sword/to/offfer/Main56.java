package cn.edu.xmu.leetcode.sword.to.offfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author summer
 * @date 2021/3/2 22:23
 * 数组中数字出现的次数【a,a,b,b,x,y】
 * 1，1，2，2，3，4
 * 【a,a,a,b】
 */
public class Main56 {

    //使用异或的特性，重复数字异或为0，0^X=X
    //使用与的特性，判断哪一位是不同的位，是1的那位
//    若 a & 0001 = 0001，则 a 的第一位为 1；
//    若 a & 0010 = 0010，则 aa 的第二位为 1 ；
//    以此类推……
    //而0001和0010之间是左移动关系
    //可以找出辅助变量m
    //对于数组中的任何一个数，i&m==0或者i&m==1，且任何一个数都会出现两次
    public int[] singleNumbers(int[] nums) {
        int n=0,x=0,y=0,m=1;
        for (int i:nums
             ) {
            n^=i;
        }
        while((n&m)==0){
            m<<=1;
        }
        for (int i:nums
             ) {
            if((i&m)==0){
                x^=i;
            }else {
                y^=i;
            }
        }
        return new int[]{
                x,y
        };
    }
    //三选1
    public int singleNumber0(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num:nums){
            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }else {
                hashMap.put(num,1);
            }
        }
        for (Integer key:hashMap.keySet()
             ) {
            if(hashMap.get(key)==1){
                return key;
            }
        }
        return 0;
    }

    public static int singleNumber1(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int n:nums){
            if(!hashSet.add(n)){
                list.add(n);
            }
        }
        for(int i:list){
            if(hashSet.contains(i)) {
                hashSet.remove(i);
            }
        }
        return hashSet.iterator().next();
    }

    public static void main(String[] args) {
        int[] nums=new int[]{3,5,5,3,8,3,5};
        System.out.println(singleNumber1(nums));
    }

}
