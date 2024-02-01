import java.util.*;

public class Main {

    static int N;
    static int eat,ans,size;
    static int[][] map;
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                map[r][c] = sc.nextInt();
                if(map[r][c]==9){
                    queue.add(new int[]{r,c,0});
                    map[r][c] = 0;
                }
            }
        }
        ans = 0;
        eat = 0;
        size= 2;
        bfs();
    }

    static void bfs(){

        while(true) {
            ArrayList<int[]> canEat = new ArrayList<>();
            int[][] dist = new int[N][N];

            while (!queue.isEmpty()) {
                int[] info = queue.poll();
                int r = info[0];
                int c = info[1];

                for (int i = 0; i < 4; i++) {
                    int idr = r + dr[i];
                    int idc = c + dc[i];
                    if (idr < 0 || idc < 0 || idr >= N || idc >= N) continue;

                    if (dist[idr][idc] == 0 && map[idr][idc] <= size) {
                        dist[idr][idc] = dist[r][c]+1;
                        queue.add(new int[]{idr,idc,dist[idr][idc]});
                        if(1<=map[idr][idc]&&map[idr][idc]<=6&&map[idr][idc]<size){
                            canEat.add(new int[]{idr,idc,dist[idr][idc]});
                        }
                    }
                }
            }

            if(canEat.isEmpty()) {
                System.out.println(ans);
                return;
            }

            int[] now = canEat.get(0);
            int nowDist = now[2];
            for(int i = 1; i<canEat.size();i++){
                if(nowDist>canEat.get(i)[2]){
                    now = canEat.get(i);
                }
                else if(nowDist == canEat.get(i)[2]){
                    if(now[0]>canEat.get(i)[0]) now = canEat.get(i);
                    else if(now[0]==canEat.get(i)[0]){
                        if(now[1]>canEat.get(i)[1]) now =canEat.get(i);
                    }
                }
            }
            map[now[0]][now[1]] = 0;
            ans+= now[2];
            eat++;
            if (size == eat) {
                size++;
                eat = 0;
            }
            queue.add(now);
        }
    }
}