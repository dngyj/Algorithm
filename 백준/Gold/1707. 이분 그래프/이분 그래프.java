import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int T, V, E;
    static ArrayList<Integer>[] list;
    static Queue<Integer> queue;
    static int[] colors;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        T = sc.nextInt();
        for(int tc=0; tc<T;tc++){
            initValues();
            boolean isValid = true;
            for(int v = 1; v<=V; v++){
                if(colors[v] == 0) {
                    isValid = checkBipartiteGraph(v);
                }
                if(!isValid) break;
            }
            System.out.println(isValid?"YES":"NO");
        }
    }

    static boolean checkBipartiteGraph(int start){
        queue = new ArrayDeque<>();
        queue.add(start);
        colors[start] = 1;
        
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int v2:list[v]){
                if(colors[v2] == 0){
                    colors[v2] = colors[v]*-1;
                    queue.add(v2);
                }
                if(colors[v2]==colors[v]){
                    return false;
                }
            }
        }
        return true;
    }

    static void initValues(){
        V = sc.nextInt();
        E = sc.nextInt();

        colors = new int[V+1];
        list = new ArrayList[V+1];
        for(int i = 0; i<V+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<E;i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            list[st].add(ed);
            list[ed].add(st);
        }
    }
}