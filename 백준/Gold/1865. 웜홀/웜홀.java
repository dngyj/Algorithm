import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N, M, W;
    static int INF = 987654321;
    static long[] dist;

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stn;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            stn = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stn.nextToken());
            M = Integer.parseInt(stn.nextToken());
            W = Integer.parseInt(stn.nextToken());

            dist = new long[N + 1];
            Arrays.fill(dist, INF);

            list = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                stn = new StringTokenizer(br.readLine());
                int st = Integer.parseInt(stn.nextToken());
                int ed = Integer.parseInt(stn.nextToken());
                int time = Integer.parseInt(stn.nextToken());
                list[st].add(new Node(ed, time));
                list[ed].add(new Node(st, time));
            }
            for (int i = 0; i < W; i++) {
                stn = new StringTokenizer(br.readLine());
                int st = Integer.parseInt(stn.nextToken());
                int ed = Integer.parseInt(stn.nextToken());
                int time = Integer.parseInt(stn.nextToken());
                list[st].add(new Node(ed, -time));
            }

            boolean isMinusCycle = false;
            for (int i = 1; i < N + 1; i++) {
                if (bellmanFord(i)) {
                    isMinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if (!isMinusCycle)  sb.append("NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bellmanFord(int st) {
        Arrays.fill(dist, INF);
        dist[st] = 0;
        boolean check = false;
        for (int i = 1; i < N; i++) {
            check = false;
            for (int j = 1; j < N + 1; j++) {
                for (Node node : list[j]) {
                    if (dist[j] == INF) continue;
                    if (dist[node.v] > dist[j] + node.w) {
                        dist[node.v] = dist[j] + node.w;
                        check = true;
//                        if(i==N) isMinusCycle = true;
                    }
                }
            }
            if (!check) break;
        }

        if (check) {
            for (int j = 1; j < N + 1; j++) {
                for (Node node : list[j]) {
                    if (dist[j] == INF) continue;
                    if (dist[node.v] > dist[j] + node.w) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}