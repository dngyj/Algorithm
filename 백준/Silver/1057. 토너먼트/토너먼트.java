import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int round = 1;
        while(true){
            if(isMeet(a,b)){
                System.out.println(round);
                break;
            }
            a = getParent(a);
            b = getParent(b);
            round++;
        }
    }

    static int getParent(int num){
        if(num%2==1){
            return (num+1)/2;
        }
        return num/2;
    }

    static boolean isMeet(int a, int b){
        if(a>b){
            int temp = a;
            a = b;
            b = temp;
        }
        if(a+1==b&&b%2==0) return true;
        else return false;
    }
}