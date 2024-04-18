import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        int cnt = 0;
        for(int i = 0;i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(y==0){
                while(!stack.isEmpty()){
                    stack.pop();
                    cnt++;
                }
            }
            else if(stack.isEmpty()) stack.push(y);
            else{
                if(stack.peek()<y){
                    stack.push(y);
                }
                else if(stack.peek()>y){
                    while(!stack.isEmpty()&&stack.peek()>y){
                        stack.pop();
                        cnt++;
                    }
                    if(stack.isEmpty()||stack.peek()<y) stack.push(y);
                }
            }
        }
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                stack.pop();
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}