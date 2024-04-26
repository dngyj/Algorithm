import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] nums;
    static int[] selected;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        selected = new int[M];
        visited = new boolean[N];

        for(int i = 0;i<N;i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        getSeq(0);
        System.out.println(sb.toString());
    }
    
    static void getSeq(int idx){
        if(idx==M){
            for(int i = 0;i<M;i++){
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
        }
        else{
            int before = -1;
            for(int i = 0;i<N;i++){
                int now = nums[i];
                if(before!=now) {
                    before = nums[i];
                    selected[idx] = nums[i];
                    getSeq(idx + 1);
                }
            }
        }
    }
}