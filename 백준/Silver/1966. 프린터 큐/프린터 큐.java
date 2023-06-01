import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt(); // 문서의 개수
            int M = sc.nextInt(); // 원하는 문서가 몇번째에 놓여있는지

            int cnt = 0;

            Queue<int[]> queue = new LinkedList<>();

            for(int i=0; i<N;i++){
                queue.add(new int[]{i, sc.nextInt()});
            }
            while(!queue.isEmpty()){
                int[] now = queue.poll();
                boolean flag = true;
                for(int[] q : queue){
                    if(q[1]>now[1]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    cnt++;
                    if(now[0] == M) break;
                }else{
                    queue.add(now);
                }
            }
            System.out.println(cnt);
        }
    }
}