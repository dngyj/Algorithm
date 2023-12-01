import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static long st, target, cnt;
    static boolean flag;
    static Queue<long[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        st = sc.nextLong();
        target = sc.nextLong();

        flag = true;
        queue.add(new long[]{st, 0});
        bfs();
        if(flag) System.out.println(-1);

    }

    public static void bfs(){
        while(!queue.isEmpty()){
            long[] info = queue.poll();
            long num = info[0];
            long cnt = info[1];

            if(num>target){
                break;
            }

            if(num == target){
                flag = false;
                System.out.println(cnt+1);
                return;
            }
            if(num* 2 <=target) {
                queue.add(new long[]{num * 2, cnt+1});
                bfs();
            }
            if(num* 10 +1<=target) {
                queue.add(new long[]{num * 10 + 1, cnt+1});
                bfs();
            }
        }


    }




}