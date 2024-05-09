import java.util.Scanner;

public class Main {
    static int N;
    static boolean[] visited = new boolean[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        backTracking("");
    }
    static void backTracking(String str){
        if(str.length() == N){
            System.out.println(str);
            System.exit(0);
        }
        else{
            for(int i = 1; i<=3;i++){
                if(isNice(str+i)) backTracking(str+i);
            }
        }
    }

    static boolean isNice(String str){
        for(int i = 1; i<=str.length()/2;i++) {
            String front = str.substring(str.length()-2*i,str.length()-i);
            String back = str.substring(str.length()-i, str.length());
            if(front.equals(back)) return false;
        }
        return true;
    }
}