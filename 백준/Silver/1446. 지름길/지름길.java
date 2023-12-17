import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Road implements Comparable<Road>{
    int start,dest,d;
    Road(int start,int dest, int d){
        this.start=start;
        this.dest=dest;
        this.d=d;
    }

    @Override
    public int compareTo(Road r) {
        return this.d-r.d;
    }

}
public class Main {
    static int result=0;
    static int n,d;
    static Road[] graph;
    static int[] dist;
    public static void dijkstra(int start) {
        PriorityQueue<Road> q=new PriorityQueue<Road>();

        q.offer(new Road(start,0,0));
        dist[start]=0;

        while(!q.isEmpty()) {
            Road fast=q.poll();
            int destination=fast.dest;
            boolean chk=false;
            for(Road r:graph) {

                if(r.start>=destination) {
                    if(r.dest>d) 
                        continue;
                    int tmp=r.start-destination;
                    chk=true;
                    if(dist[r.dest]>dist[destination]+r.d+tmp) {
                        dist[r.dest]=dist[destination]+r.d+tmp;
                        q.offer(new Road(destination,r.dest,dist[r.dest]));
                    }
                }

            }

            //if(q.isEmpty())
            dist[d]=Math.min(dist[destination]+d-destination,dist[d]);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        dist=new int[d+1];
        for(int i=0;i<d+1;i++) {
            dist[i]=i;
        }
        graph=new Road[n];
        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int dest=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            graph[i]=new Road(start,dest,d);
        }

        dijkstra(0);
        System.out.println(dist[d]);
    }
}