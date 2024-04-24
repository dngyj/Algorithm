import java.util.Scanner;

public class Main {

    static int N;
    static int[] nums;
    static int[] operators = new int[4];
    static int[] selected;
    static int[] visited;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        input();

        selected = new int[N-1];
        visited = new int[4];
        visited = operators.clone();

        perm(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void input(){
        N = sc.nextInt();
        nums = new int[N];
        for(int i = 0;i<N;i++){
            nums[i] = sc.nextInt();
        }
        for(int i = 0;i<4;i++){
            operators[i] = sc.nextInt();
        }
    }

    static void perm(int idx){
        if(idx==N-1){
            calculate(selected);
        }
        else{
            for(int i = 0; i<4;i++){
                if(visited[i]>0) {
                    visited[i]--;
                    selected[idx]=i;
                    perm(idx+1);
                    visited[i]++;
                }
            }
        }
    }

    static void calculate(int[] selected){
        int num = nums[0];

        for(int i = 0;i<N-1;i++){
            if(selected[i]==0) num +=nums[i+1];
            if(selected[i]==1) num -=nums[i+1];
            if(selected[i]==2) num *=nums[i+1];
            if(selected[i]==3) num /=nums[i+1];
        }
        max = Math.max(max,num);
        min = Math.min(min,num);
    }
}