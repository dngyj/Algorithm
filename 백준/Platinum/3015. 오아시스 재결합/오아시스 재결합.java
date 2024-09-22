import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        long cnt = 0;

        for(int i = 0; i<N;i++){
            int height = sc.nextInt();

            while(!stack.isEmpty()&&height>stack.peek()[0]){
                cnt+=stack.pop()[1];
            }

            if(stack.isEmpty()){
                stack.push(new int[]{height, 1});
            }
            else{
                if(height<stack.peek()[0]){
                    stack.push(new int[]{height, 1});
                    cnt++;
                }
                else{
                    cnt+=stack.peek()[1]++;
                    if(stack.size()>1) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}