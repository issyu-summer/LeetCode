package leetcode.dfs;

/**
 * @author summer
 * @see <a href="https://www.bilibili.com/video/BV1qE411E7di?from=search&seid=17694553733113701862">dfs介绍</a><br/>
 * @since 2021/4/30 11:12
 */
public class Main {


    /**
     * 全排列、非重复
     */
    int count=0;
    public void dfs(char[]ar,boolean[]visited,int level,StringBuilder sBuilder){
        //截至条件
        if(level==ar.length){
            System.out.println(sBuilder.toString());
            count++;
            return;
        }
        //遍历候选元素
        for (int i = 0; i < ar.length; i++) {
            char ch=ar[i];
            //帅选
            if(!visited[i]){
                sBuilder.append(ch);
                visited[i]=true;
                dfs(ar,visited,level+1,sBuilder);
                //回溯
                sBuilder.deleteCharAt(sBuilder.length()-1);
                visited[i]=false;
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Main main=new Main();
        main.dfs("AAC".toCharArray(),new boolean[4],0,new StringBuilder());
        System.out.println(main.getCount());
    }
}
