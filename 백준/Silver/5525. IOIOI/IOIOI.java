import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        String str = sc.next();

        int cnt = 0;
        int ans = 0;
        for(int i = 1; i<L-1;i++){
            if(str.charAt(i-1)=='I'&&str.charAt(i)=='O'&&str.charAt(i+1)=='I'){
                cnt++;
                if(cnt==N){
                    ans++;
                    cnt--;
                }
                i++;
            }
            else cnt=0;
        }
        System.out.println(ans);
    }
}