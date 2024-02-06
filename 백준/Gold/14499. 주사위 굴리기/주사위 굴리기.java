import java.util.Scanner;

public class Main {

    static int N,M,K;
    static int x,y;
    static int[][] map;
    static int[] dice;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        dice = new int[6];

        for(int r = 0; r<N;r++){
            for(int c=0;c<M;c++){
                map[r][c] = sc.nextInt();
            }
        }
        for(int i = 0; i<K;i++){
            int command = sc.nextInt()-1;
            move(command);
        }

    }
    static void move(int command){
        int idr = x+dr[command];
        int idc = y+dc[command];
        if(idr<0||idc<0||idr>=N||idc>=M) return;

        rollDice(command);

        x=idr;
        y=idc;

        if(map[idr][idc]==0) map[idr][idc] = dice[5];
        else {
            dice[5] = map[idr][idc];
            map[idr][idc] = 0;
        }
        System.out.println(dice[0]);
    }

    static void rollDice(int command){
        int temp = dice[5];
        switch(command) {
            case 0://동쪽
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = temp;
                break;
            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = temp;
                break;
            case 3:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = temp;
        }
    }
}