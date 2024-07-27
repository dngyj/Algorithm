import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int isNow = 1;
        int[] waiting = new int[N];

        for(int i =0;i<N;i++){
            waiting[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        for(int now : waiting){
            if(isNow==now){
                isNow++;
            }
            else stack.push(now);

            while (!stack.isEmpty() && stack.peek() == isNow) {
                stack.pop();
                isNow++;
            }
        }
        System.out.println(stack.isEmpty()?"Nice":"Sad");
    }
}