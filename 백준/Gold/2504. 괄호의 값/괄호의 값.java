import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> stack = new Stack<>();

        int ans = 0;
        int tmp = 1;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                stack.push(c);
                tmp*=2;
            }
            if(c=='['){
                stack.push(c);
                tmp*=3;
            }
            if(c==')'){
                if(stack.isEmpty()||stack.peek()!='(') {
                    System.out.println(0);
                    return;
                }
                if(str.charAt(i-1)=='(') ans+=tmp;
                tmp/=2;
                stack.pop();
            }
            if(c==']'){
                if(stack.isEmpty()||stack.peek()!='[') {
                    System.out.println(0);
                    return;
                }
                if(str.charAt(i-1)=='[') ans+=tmp;
                tmp/=3;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(ans);
    }
}