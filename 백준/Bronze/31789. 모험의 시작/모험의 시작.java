import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int money = sc.nextInt();
        int def = sc.nextInt();

        boolean isWin = false;
        for(int i = 0; i<N; i++){
            int price = sc.nextInt();
            int atk = sc.nextInt();
            if(price<=money&&atk>def){
                isWin = true;
                break;
            }
        }
        System.out.println(isWin?"YES":"NO");
    }
}