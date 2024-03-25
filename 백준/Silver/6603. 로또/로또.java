import java.util.Scanner;

public class Main {
    static int K;
    static int[] nums;
    static boolean[] selected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            K = sc.nextInt();
            if(K==0) break;
            nums = new int[K];
            selected = new boolean[K];
            for(int i =0;i<K;i++){
                nums[i] = sc.nextInt();
            }
            comb(0,0);
            System.out.println();
        }
    }
    
    static void comb(int idx, int depth){
        if(depth == 6){
            for(int i=0;i<K;i++){
                if(selected[i]) System.out.print(nums[i]+" ");
            }
            System.out.println();
        }

        for(int i=idx;i<K;i++){
            selected[i] = true;
            comb(i+1,depth+1);
            selected[i] = false;
        }
    }
}