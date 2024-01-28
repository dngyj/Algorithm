import java.util.*;

public class Main {

    static char[][] wheel = new char[4][8];
    static boolean[] visited;
    static Queue<int[]> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i =0;i<4;i++){
            wheel[i] = sc.next().toCharArray();
        }
        int K = sc.nextInt();
        for(int k=0;k<K;k++){
            int num = sc.nextInt()-1;
            int direction = sc.nextInt();
            visited = new boolean[4];
            queue = new LinkedList<>();
            checkWheel(num, direction);

            while(!queue.isEmpty()){
                int[] info = queue.poll();
                int n = info[0];
                int d = info[1];
                rotate(n,d);
            }
        }

        int score = 0;
        for(int r=0;r<4;r++){
            score += (int) ((wheel[r][0]-48)*Math.pow(2,r));
        }
        System.out.println(score);
    }

    static void checkWheel(int num, int d){
        int[] dn= {-1,1};
        visited[num] = true;
        queue.add(new int[]{num, d});

        for(int i =0;i<2;i++){
            int nextNum = num+dn[i];
            if(nextNum<0||nextNum>=4) continue;
            if(visited[nextNum]) continue;
            if(i==0&&wheel[num][6]!=wheel[nextNum][2]){
                int nextD = 0;
                if(d==1) nextD = -1;
                if(d==-1) nextD = 1;
                checkWheel(nextNum, nextD);
            }
            if(i==1&&wheel[num][2]!=wheel[nextNum][6]){
                int nextD = 0;
                if(d==1) nextD = -1;
                if(d==-1) nextD = 1;
                checkWheel(nextNum, nextD);
            }
        }
    }

    static void rotate(int num, int d){

        if(d==1){ //시계
            char temp = wheel[num][7];
            for(int i=6;i>=0;i--){
                wheel[num][i+1] = wheel[num][i];
            }
            wheel[num][0] = temp;
        }
        if(d==-1){ //반시계
            char temp = wheel[num][0];
            for(int i=1;i<8;i++){
                wheel[num][i-1] = wheel[num][i];
            }
            wheel[num][7] = temp;
        }
    }
}