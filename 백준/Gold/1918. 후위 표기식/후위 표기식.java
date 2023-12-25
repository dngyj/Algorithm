import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        String str = sc.next();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            //+, -, *, /, (, )
            switch (c){
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while(!stack.isEmpty()&&stack.peek()!='('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                case '-': case '+': case '*':  case '/':
                    while(!stack.isEmpty()&&priority(stack.peek())>=priority(c)){
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    public static int priority(char oper){

        if(oper == '*'||oper == '/') return 2;
        else if(oper == '+'||oper=='-') return 1;
        else return 0;
    }
}