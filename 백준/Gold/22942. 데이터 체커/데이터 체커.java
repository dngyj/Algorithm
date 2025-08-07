import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<int[]> circles = new ArrayList<>();
        for(int i = 0; i<N; i++){
            int x = sc.nextInt();
            int r = sc.nextInt();

            circles.add(new int[]{x-r, i});
            circles.add(new int[]{x+r, i});
        }

        circles.sort((a,b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();

        for(int[] circle : circles){
            int index = circle[1];
            if(!stack.isEmpty()){
                if(stack.peek()[1]==index){
                    stack.pop();
                }
                else stack.push(circle);
            }
            else{
                stack.push(circle);
            }
        }

        if(stack.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
