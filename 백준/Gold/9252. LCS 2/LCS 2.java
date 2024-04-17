import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        int max = -1;
        for(int i = 1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        sb.append(dp[str1.length()][str2.length()]).append("\n");

        Stack<Character> stack  = new Stack<>();

        int i = str1.length();
        int j = str2.length();
        while(i>0&&j>0){

            if(dp[i][j]==dp[i-1][j]){
                i--;
            }
            else if(dp[i][j]==dp[i][j-1]){
                j--;
            }
            else{
                stack.push(str1.charAt(i-1));
                i--;
                j--;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}