import java.util.Scanner;

public class Main {

    static int N;
    static int[] nums;
    static int[] selected;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        for(int i = 0; i<N;i++){
            nums[i] = sc.nextInt();
        }
        backTracking(0);
        System.out.println(max);
    }
    static void backTracking(int cnt){
        if(cnt == N){
            int sum = 0;
            for(int i = 0;i<N-1;i++){
                sum += Math.abs(selected[i]-selected[i+1]);
            }
            max = Math.max(sum, max);
            return;
        }
        else{
            for(int i = 0; i<N;i++){
                if(visited[i]) continue;
                selected[cnt] = nums[i];
                visited[i] = true;
                backTracking(cnt+1);
                visited[i] = false;
            }
        }
    }


}