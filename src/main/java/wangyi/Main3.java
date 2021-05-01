package wangyi;

import java.util.Scanner;

/**
 * @author summer
 * @see <a href=""></a><br/>
 * @since 2021/4/18 16:42
 */
public class Main3 {

    public void solution(){
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        String [] ar=new String[n*2];
        for (int i = 0; i < n*2; i++) {
            ar[i]=scanner.next();
        }

        for (int i = 0,j=1; j < ar.length; i+=2,j+=2) {
            int length=ar[i].length();
            if(length%2==0){
                if(recur(ar[i],ar[j],length)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }else {
                for (int k = 0; k < length; k++) {
                    if(ar[i].indexOf(k)!=ar[j].indexOf(k)){
                        System.out.println("NO");
                    }
                }
                System.out.println("YES");
            }
        }
    }

    public boolean recur(String a,String b,int length){
        if(length==1&& !a.equals(b)){
            return false;
        }
        if(length == 1){
            return true;
        }
        if(a.length()!=length&&!a.equals(b)){
            return false;
        }
        return recur(a.substring(0,length/2),b.substring(0,length/2),length/2)
                ||recur(a.substring(0,length/2),b.substring(length/2),length/2)
                ||recur(a.substring(length/2),b.substring(0,length/2),length/2)
                ||recur(a.substring(length/2),b.substring(length/2),length/2);
    }

    public static void main(String[] args) {
        Main3 main = new Main3();
        main.solution();

    }
}
