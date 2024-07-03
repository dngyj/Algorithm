import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        if(N.length()==1) N = 0+N;
        int cnt = 1;
        int num = Integer.parseInt(N);
        while(true){
            int sum = num/10+num%10;
            int newNum = num%10*10+sum%10;
            if(newNum == Integer.parseInt(N)) break;
            num = newNum;
            cnt++;
        }
        System.out.println(cnt);
    }
}