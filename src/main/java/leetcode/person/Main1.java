package leetcode.person;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/5 16:20
 */
public class Main1 {
    public static int orchestraLayout(int num, int xPos, int yPos) {
        int [][]m=new int[num][num];
        int k = 1;
        for(int i=0;i<=num/2;i++){
            for(int j = i;j<num-i;j++){
                m[i][j] = k++;
                //上方行方向
                if(k==10){
                    k=1;
                }
                if(i==xPos&&j==yPos){
                    return m[xPos][yPos];
                }
            }
            for(int j = i+1;j<num-i;j++){
                m[j][num-i-1] = k++;
                //右侧列方向
                if(k==10){
                    k=1;
                }
                if(j==xPos&&num-i-1==yPos){
                    return m[xPos][yPos];
                }
            }
            for(int j = num-i-2;j>=i;j--){
                m[num-i-1][j] = k++;
                //下方行方向
                if(k==10){
                    k=1;
                }
                if(num-i-1==xPos&&j==yPos){
                    return m[xPos][yPos];
                }
            }
            for(int j = num-i-2;j>i;j--){
                m[j][i] = k++;
                //左侧列方向
                if(k==10){
                    k=1;
                }
                if(j==xPos&&i==yPos){
                    return m[xPos][yPos];
                }
            }

        }
        return 0;
    }

    public static int orchestraLayout1(int num, int xPos, int yPos) {
        int k = 1;
        for(int i=0;i<=num/2;i++){
            for(int j = i;j<num-i;j++){
                k++;
                //上方行方向
                if(k==9){
                    k=1;
                }
                if(i==xPos&&j==yPos){
                    return k;
                }
            }
            for(int j = i+1;j<num-i;j++){
                k++;
                //右侧列方向
                if(k==9){
                    k=1;
                }
                if(j==xPos&&num-i-1==yPos){
                    return k;
                }
            }
            for(int j = num-i-2;j>=i;j--){
                k++;
                //下方行方向
                if(k==9){
                    k=1;
                }
                if(num-i-1==xPos&&j==yPos){
                    return k;
                }
            }
            for(int j = num-i-2;j>i;j--){
                k++;
                //左侧列方向
                if(k==9){
                    k=1;
                }
                if(j==xPos&&i==yPos){
                    return k;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(orchestraLayout(4,1,2));
    }
}
