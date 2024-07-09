import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N ,M, L, K;
    static List<int[]> stars = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        int max = -1;
        for(int i = 0; i<K;i++){
            for(int j = 0; j<K;j++){
                int r = stars.get(i)[0];
                int c = stars.get(j)[1];
                max = Math.max(countStar(r, c), max);
            }
        }
        int answer = K-max;
        System.out.println(answer);
    }
    static int countStar(int r, int c){
        int cnt = 0;
        for(int k = 0; k<K;k++){
            int starR = stars.get(k)[0];
            int starC = stars.get(k)[1];
            if(r<=starR&&starR<=r+L && c<=starC&&starC<=c+L) cnt++;
        }
        return cnt;
    }

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        K = sc.nextInt();

        for(int i = 0; i<K;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            stars.add(new int[]{x,y});
        }
    }
}