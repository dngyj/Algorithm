import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int INF = Integer.MAX_VALUE;

    public static class Node implements Comparable<Node>{
        int r;
        int c;
        int w;

        public Node(int r, int c, int w){
            this.r=r;
            this.c=c;
            this.w=w;
        }

        @Override
        public int compareTo(Node o){
            return w-o.w;
        }

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int tc = 0;
        while(true){
            tc++;
            int N = sc.nextInt();
            if(N==0){
                break;
            }
            map = new int[N][N];
            dp = new int[N][N];
            for(int r = 0; r<N; r++) {
                Arrays.fill(dp[r], INF);
            }
            for(int r=0;r<N;r++){
                for(int c=0; c<N;c++){
                    map[r][c] = sc.nextInt();
                }
            }
            int cost = dijkstra(N);
            sb.append("Problem " + tc + ": " + cost+"\n");
        }
        System.out.println(sb.toString());
    }

    public static int dijkstra(int N){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0,0,map[0][0]));
        dp[0][0] = map[0][0];

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int r = node.r;
            int c = node.c;
            int cost = node.w;

            if(r==N-1&&c==N-1){
                return cost;
            }

            for(int d=0;d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];

                if(idr<0||idc<0||idr>=N||idc>=N) continue;

                if(dp[idr][idc] == INF || dp[idr][idc]>dp[r][c]+map[idr][idc]){
                    dp[idr][idc] = dp[r][c] + map[idr][idc];
                    queue.add(new Node(idr,idc,cost+map[idr][idc]));
                }
            }
        }
        return -1;
    }
}