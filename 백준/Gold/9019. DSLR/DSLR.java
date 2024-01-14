import java.util.*;

public class Main {

    static int from, to;
    static boolean[] visited;
    static String[] command;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 0; tc<T; tc++){
            visited = new boolean[10001];
            command = new String[10001];
            from = sc.nextInt();
            to = sc.nextInt();

            bfs(from);
        }
    }

    static void bfs(int from){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(from);
        visited[from] = true;
        command[from] ="";

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now==to){
                System.out.println(command[to]);
                return;
            }

            for(int i=0;i<4;i++){
                //D n이 2배
                if(i==0){
                    int next = (2*now)%10000;
                    if(!visited[next]) {
                        visited[next] = true;
                        command[next] = command[now]+"D";
                        queue.add(next);
                    }
                }
                //S n-1
                if(i==1){
                    int next = now==0?9999:now-1;
                    if(!visited[next]) {
                        visited[next] = true;
                        command[next] = command[now]+"S";
                        queue.add(next);
                    }
                }
                //L n을 왼편으로 회전
                if(i==2){
                    int next = (now%1000)*10+now/1000;
                    if(!visited[next]) {
                        visited[next] = true;
                        command[next] = command[now]+"L";
                        queue.add(next);
                    }
                }
                //R n을 오른편으로 회전
                if(i==3){
                    int next = (now/10)+(now%10)*1000;
                    if(!visited[next]) {
                        visited[next] = true;
                        command[next] = command[now]+"R";
                        queue.add(next);
                    }
                }
            }
        }
    }

}