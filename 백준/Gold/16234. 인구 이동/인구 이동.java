import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N,L,R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<Node> list;

    static boolean flag;
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][N];

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                map[r][c] = sc.nextInt();
            }
        }

        int day = -1;
        flag = true;
        while(flag){
            visited = new boolean[N][N];
            flag = false;
            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    if(!visited[r][c]) openBorder(r,c);
                }
            }
            day++;
        }
        System.out.println(day);
    }

    static void openBorder(int row, int col){
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();
        queue.add(new Node(row,col));
        list.add(new Node(row,col));

        int sum = map[row][col];
        while(!queue.isEmpty()){
            Node info = queue.poll();
            int r = info.r;
            int c = info.c;
            visited[r][c] = true;

            for(int i =0; i<4;i++){
                int idr = r+dr[i];
                int idc = c+dc[i];
                if(idr<0||idc<0||idr>=N||idc>=N) continue;
                if(visited[idr][idc]) continue;

                if(L<=Math.abs(map[idr][idc]-map[r][c])&&Math.abs(map[idr][idc]-map[r][c])<=R){
                    visited[idr][idc] = true;
                    flag = true;
                    sum+=map[idr][idc];
                    list.add(new Node(idr,idc));
                    queue.add(new Node(idr,idc));
                }
            }
        }
        for(Node node : list){
            map[node.r][node.c] = sum/list.size();
        }
    }

}