import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] nums;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        for(int i = 0;i<N;i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        selected = new int[M];
        visited = new boolean[N];
        getSeq(0,0);
    }

    static void getSeq(int idx, int depth){
        if(depth==M){
            for(int i = 0;i<M;i++){
                System.out.print(selected[i]+" ");
            }
            System.out.println();
        }
        else{
            int before = -1;
            for(int i = idx;i<N;i++){
                int now = nums[i];
                if(before==now) continue;
                if(!visited[i]){
                    before = now;
                    visited[i] = true;
                    selected[depth] = nums[i];
                    getSeq(i+1, depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}