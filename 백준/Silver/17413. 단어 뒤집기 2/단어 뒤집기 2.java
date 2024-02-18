import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<str.length();i++){
            queue.add(str.charAt(i));
        }
        while(!queue.isEmpty()){
            if(queue.peek()=='<'){
                if(!stack.isEmpty()){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                }
                sb.append(queue.poll());
                while(queue.peek()!='>'){
                    sb.append(queue.poll());
                }
                sb.append(queue.poll());
            }
            else if(queue.peek()==' '){
                if(!stack.isEmpty()){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                }
                sb.append(queue.poll());
            }
            else {
                stack.push(queue.poll());
            }
        }
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
        }
        System.out.println(sb.toString());
    }
}