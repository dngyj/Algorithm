import java.util.Scanner;

public class Main {

    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        char[] str1= sc.next().toCharArray();
        char[] str2= sc.next().toCharArray();

        dp = new int[str1.length+1][str2.length+1];

        int ans = -1;
        for(int i =1;i<str1.length+1;i++){
            for(int j=1;j<str2.length+1;j++){
                if(str1[i-1]==str2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                ans = Math.max(dp[i][j],ans);
            }
        }
        System.out.println(ans);
    }
}