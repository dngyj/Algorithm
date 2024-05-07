import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] king = sc.next().toCharArray();
        char[] stone = sc.next().toCharArray();
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            String d = sc.next();
            char[] kingNext = king.clone();
            char[] stoneNext = stone.clone();
            moveChess(kingNext, d);
            if(!checkRange(kingNext)) continue;
            if(Arrays.equals(kingNext, stoneNext)){
                moveChess(stoneNext,d);
                if(!checkRange(stoneNext)) continue;
            }
            king = kingNext;
            stone = stoneNext;
        }
        System.out.println(king);
        System.out.println(stone);
    }

    static void moveChess(char[] next, String d){
        if(d.equals("R")){
            next[0]++;
        }
        if(d.equals("L")){
            next[0]--;
        }
        if(d.equals("B")){
            next[1]--;
        }
        if(d.equals("T")){
            next[1]++;
        }
        if(d.equals("RT")){
            next[0]++;
            next[1]++;
        }
        if(d.equals("LT")){
            next[0]--;
            next[1]++;
        }
        if(d.equals("RB")){
            next[0]++;
            next[1]--;
        }
        if(d.equals("LB")){
            next[0]--;
            next[1]--;
        }
    }

    static boolean checkRange(char[] next){
        if(next[1]<'1'||next[1]>'8'||next[0]<'A'||next[0]>'H') return false;
        else return true;
    }
}