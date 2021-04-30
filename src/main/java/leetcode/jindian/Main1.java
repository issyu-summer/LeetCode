package leetcode.jindian;

import java.util.HashSet;

/**
 * 判断是否重复
 * @author summer
 * @date 2021/3/1 18:36
 */
public class Main1 {

    public static boolean isUnique(String s){
        HashSet<Byte> hashSet = new HashSet<>();
        byte [] bytes = s.getBytes();
        for(int i=0;i<s.length();i++){
            if(!hashSet.add(bytes[i])){
                return false;
            }
        }
        return true;
    }
}
