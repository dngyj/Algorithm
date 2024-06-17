import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Node implements Comparable<Node>{
        int r;
        int c;
        int w;
        Node(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }
        @Override
        public int compareTo(Node o){
            return w-o.w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();


        dist = new int[N][M];
        for(int r=0;r<N;r++){
            Arrays.fill(dist[r],INF);
        }

        map = new int[N][M];
        for(int r = 0; r<N;r++){
            String str = sc.next();
            for(int c=0;c<M;c++){
                char ch = str.charAt(c);
                map[r][c] = ch-48;
            }
        }
        dijkstra();
        System.out.println(dist[N-1][M-1]);
    }

    static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0,0,map[0][0]));
        dist[0][0] = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int r = node.r;
            int c = node.c;
            int w = node.w;
            for(int d=0;d<4;d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(dist[idr][idc]<w) continue;
                if(dist[idr][idc]>w+map[idr][idc]){
                    dist[idr][idc] = w+map[idr][idc];
                    queue.add(new Node(idr,idc,w+map[idr][idc]));
                }
            }
        }
    }
}