import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();

        int tempR = sc.nextInt();
        int tempC = sc.nextInt();
        list.add(new int[]{tempR, tempC});
        int sum = 0;
        for (int i = 1; i < N; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int dist = getDistance(r,c,tempR,tempC);
            sum+=dist;
            tempR=r;
            tempC=c;
            list.add(new int[]{r, c});
        }

        int maxMinus = -1;
        for (int i = 1; i < N-1; i++) {
            int r1 = list.get(i-1)[0];
            int c1 = list.get(i-1)[1];
            int r = list.get(i)[0];
            int c = list.get(i)[1];
            int r2 = list.get(i+1)[0];
            int c2 = list.get(i+1)[1];
            int minusSum = getDistance(r,c,r1,c1)+getDistance(r,c,r2,c2)-getDistance(r1,c1,r2,c2);
            maxMinus = Math.max(maxMinus, minusSum);
        }
        System.out.println(sum-maxMinus);
    }

    static int getDistance(int r, int c, int r1, int c1){
        return Math.abs(r1-r)+Math.abs(c1-c);
    }
}