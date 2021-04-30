package leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author summer
 * @see <a href="https://leetcode-cn.com/problems/generate-parentheses/">括号生成</a><br/>
 * @since 2021/4/5 9:41
 */
public class Main22 {
    /**
     * DFS遍历,过滤掉左右不相等的,或这括号超过n的一半的
     */
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        dfs(list,1,n*2);
        return list;
    }

    private void dfs(List<String> list, int level,int n) {
        if(level ==n){
            return;
        }
//        for()
    }
}
