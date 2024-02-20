import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        String[] wheel = new String[N];

        int idx = 0;
        for(int i=0;i<K;i++){
            int S = sc.nextInt();
            String str = sc.next();
            idx = idx+S>=N?(idx+S)%N:idx+S;

            if(wheel[idx]==null||wheel[idx].equals(str)){
                wheel[idx] = str;
            }else {
                System.out.println("!");
                return;
            }
        }
        String ans = "";

        for(int i = idx;i>=0;i--){
            if(wheel[i]==null) ans+="?";
            else if(ans.contains(wheel[i])) {
                System.out.println("!");
                return;
            }
            else ans+=wheel[i];
        }
        for(int i = N-1;i>idx;i--){
            if(wheel[i]==null) ans+="?";
            else if(ans.contains(wheel[i])) {
                System.out.println("!");
                return;
            }
            else ans+=wheel[i];
        }
        System.out.println(ans);
    }

}