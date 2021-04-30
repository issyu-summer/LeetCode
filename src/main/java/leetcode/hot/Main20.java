package leetcode.hot;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/">有效的括号</a><br/>
 * @since 2021/4/4 19:35
 */
public class Main20 {

    static final Map<Character,Character> MAP =new HashMap<>(){
        {put('{','}');put('(',')');put('[',']');}
    };
    /**
     * 匹配问题，可以使用辅助栈
     */
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[] chars = s.toCharArray();
        if(s.length() > 0 && !MAP.containsKey(s.charAt(0))) {
            return false;
        }
        for(char c:chars){
            if(MAP.containsKey(c)){
                stack.push(c);
            }
            if(MAP.containsValue(c)){
                if(stack.isEmpty()){
                    return false;
                }
                if(c!=MAP.get(stack.peek())){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}
