import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int maxScore = -5;
    static int score;
    static int[][] players;
    static int[] orders = new int[9];
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) {
        input();
        setOrder(0);
        System.out.println(maxScore);
    }
    static void input(){
        N = sc.nextInt();
        players = new int[N][9];
        for(int i =0;i<N;i++){
            for(int j=0;j<9;j++){
                players[i][j] = sc.nextInt();
            }
        }
    }

    static void setOrder(int depth){
        if(depth == 8){
            playGame(orders);
            maxScore = Math.max(maxScore,score);
        }
        else {
            for (int i = 1; i < 9; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if(depth>=3) orders[depth+1] = i;
                    else orders[depth] = i;
                    setOrder(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
    static void playGame(int[] order){
        int inning = 0;
        int nowNum = 0;
        score = 0;

        for(int r=0; r<N; r++) {
            int inningScore = 0;
            int outCnt = 0;
            boolean[] base = new boolean[4];

            while(outCnt < 3) {
                switch(players[r][order[nowNum]]) {
                    // 아웃
                    case 0:
                        outCnt++;
                        break;
                    // 1루타
                    case 1:
                        if(base[3]) {
                            inningScore++;
                            base[3] = false;
                        }
                        if(base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }
                        if(base[1]) {
                            base[2] = true;
                        }
                        base[1] = true;
                        break;
                    // 2루타
                    case 2:
                        if(base[3]) {
                            inningScore++;
                            base[3] = false;
                        }
                        if(base[2]) {
                            inningScore++;
                        }
                        if(base[1]) {
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;
                        break;
                    // 3루타
                    case 3:
                        if(base[3]) {
                            inningScore++;
                        }
                        if(base[2]) {
                            inningScore++;
                            base[2] = false;
                        }
                        if(base[1]) {
                            inningScore++;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;
                    // 홈런
                    case 4:
                        if(base[3]) {
                            inningScore++;
                            base[3] = false;
                        }
                        if(base[2]) {
                            inningScore++;
                            base[2] = false;
                        }
                        if(base[1]) {
                            inningScore++;
                            base[1] = false;
                        }
                        inningScore++;
                        break;
                }
                nowNum++;
                if(nowNum > 8) {
                    nowNum = 0;
                }
            }
            score += inningScore;
        }

    }
}