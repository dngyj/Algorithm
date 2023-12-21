import java.util.*;

public class Main {

    static int N, time;
    static int direction;
    static int head_r, head_c;
    static int[][] board;

    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];

        int K = sc.nextInt();
        for(int i = 0; i<K;i++){
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            board[r][c] = 2;
        }
        int L = sc.nextInt();
        for(int i =0;i<L;i++){
            int sec = sc.nextInt();
            String C = sc.next(); //L: 왼쪽 / D: 오른쪽
            map.put(sec,C);
        }
        play();
        System.out.println(time+1);
    }

    public static void play(){
        Queue<int[]> snakeBody = new LinkedList<>(); //head
        head_r = 0;
        head_c = 0;
        time = 0;
        direction = 0; // 0 오 / 1 아 / 2 왼 / 3 위
        board[0][0] = 1;

        snakeBody.add(new int[]{0,0});

        while(true) {
            if(map.containsKey(time)){
                if(map.get(time).equals("L")) {
                    direction = direction-1;
                    if(direction<0) direction = 4+direction;
                }
                if(map.get(time).equals("D")){
                    direction = direction+1;
                    if(direction>=4) direction = direction-4;
                }
            }
            head_r += dr[direction];
            head_c += dc[direction];
            //다음 머리

            if(head_r<0||head_c<0||head_r>=N||head_c>=N) break;
            if(board[head_r][head_c]==1) break;

            if(board[head_r][head_c]==0){
                board[head_r][head_c] = 1;
                snakeBody.add(new int[]{head_r,head_c});
                int[] tail = snakeBody.poll();
                board[tail[0]][tail[1]] = 0;
            }

            if(board[head_r][head_c]==2){
                board[head_r][head_c] = 1;
                snakeBody.add(new int[]{head_r,head_c});
            }
            time++;
        }
    }
}