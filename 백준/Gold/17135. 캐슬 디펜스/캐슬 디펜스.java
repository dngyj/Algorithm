import java.util.*;

public class Main {

    static int N,M,D;
    static int[][] map;
    static int[][] cloneMap;
    static boolean[] visited;
    static int[] selected = new int[3];
    static ArrayList<int[]> enemyList;
    static int cnt;
    static int max = -1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        selectArcher(0,0);
        System.out.println(max);
    }

    static void selectArcher(int depth, int idx){
        if(depth == 3){
            cloneMap = new int[N][M];
            for(int r = 0; r<N;r++){
                for(int c=0;c<M;c++){
                    cloneMap[r][c] = map[r][c];
                }
            }
            playGame();
            max =Math.max(cnt,max);
        }
        else{
            for(int i = idx; i<M;i++){
                if(!visited[i]) {
                    visited[i] = true;
                    selected[depth] = i;
                    selectArcher(depth+1, i+1);
                    visited[i] = false;
                }
            }
        }
    }

    static void playGame(){
        cnt = 0;
        while(!isEnemyEmpty()){
            destroyEnemy();
            enemyMove();
        }
    }

    static void destroyEnemy(){
        enemyList = new ArrayList<>();
        for(int i = 0;i<3;i++) {
            selectEnemy(selected[i]);
        }
        for(int[] enemy:enemyList){
            if(cloneMap[enemy[0]][enemy[1]]==1) {
                cloneMap[enemy[0]][enemy[1]] = 0;
                cnt++;
            }
        }
    }
    
    static void selectEnemy(int archerCol){
        int targetR = -1;
        int targetC = -1;
        int min = 987654321;

        for(int c=0;c<M;c++){
            for(int r = 0; r<N;r++){
                if(cloneMap[r][c] == 1){
                    int distance = getDistance(r,c,archerCol);
                    if(distance<=D&&distance<min){
                        targetR = r;
                        targetC = c;
                        min = distance;
                    }
                }
            }
        }
        if(targetR!=-1) enemyList.add(new int[]{targetR,targetC});
    }

    static int getDistance(int r, int c, int archerCol){
        return Math.abs(r-N)+Math.abs((c-archerCol));
    }
    
    static void enemyMove(){
        ArrayList<int[]> list = new ArrayList<>();
        for(int r = 0; r<N;r++){
            for(int c=0;c<M;c++){
                if(cloneMap[r][c] == 1){
                    list.add(new int[]{r+1,c});
                    cloneMap[r][c] = 0;
                }
            }
        }
        for(int[] movePos:list){
            int r = movePos[0];
            int c = movePos[1];
            if(r>=N) continue;
            cloneMap[r][c] = 1;
        }
    }
    
    static boolean isEnemyEmpty(){
        for(int r = 0; r<N;r++){
            for(int c=0;c<M;c++){
                if(cloneMap[r][c] == 1) return false;
            }
        }
        return true;
    }

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[M];
        for(int r = 0; r<N;r++){
            for(int c=0;c<M;c++){
                map[r][c] = sc.nextInt();
            }
        }
    }
}