import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] NGE = new int[N];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<N;i++){
            NGE[i] = sc.nextInt();
        }

        for(int i = 0;i<N;i++){
            while(!stack.isEmpty()&&NGE[stack.peek()]<NGE[i]){
                NGE[stack.pop()] = NGE[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            NGE[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            sb.append(NGE[i]+" ");
        }
        System.out.println(sb);
    }
}