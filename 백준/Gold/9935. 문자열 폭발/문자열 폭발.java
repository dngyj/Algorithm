import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = sc.next();
        String blast = sc.next();

        for(int i =0;i<str.length();i++){
            stack.push(str.charAt(i));

            if(stack.size()>=blast.length()){
                boolean isSame = true;
                for(int k=0;k<blast.length();k++){
                    if(stack.get(stack.size()-blast.length()+k) != blast.charAt(k)){
                        isSame =false;
                        break;
                    }
                }
                if(isSame){
                    for(int k=0;k<blast.length();k++){
                        stack.pop();
                    }
                }
            }
        }
        for(char c : stack){
            sb.append(c);
        }
        System.out.println(sb.length()>0?sb:"FRULA");
    }
}