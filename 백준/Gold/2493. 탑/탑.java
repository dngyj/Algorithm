import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        Stack<int[]> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int[] tower = new int[N];

        for(int n=0; n<N;n++){
            tower[n] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            while(!stack.empty()){ //비어있지않을때
                if(stack.peek()[1]<tower[i]){ //stack에 쌓여있는 값이 지금 들어갈 tower보다 작으면 제거
                    stack.pop();
                }
                else{ // 아니라면 stack 의 인덱스 값을 출력
                    sb.append(stack.peek()[0]+" ");
                    break;
                }
            }
            if(stack.isEmpty()) sb.append("0 "); // 스택 비어있으면 0 출력
            stack.push(new int[]{i+1, tower[i]});

        }
        System.out.println(sb.toString());
    }
}