import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0;t<T;t++){
            int cost = sc.nextInt();
            int quarter = cost/25;
            int dime = (cost%25)/10;
            int nickel = (cost%25%10)/5;
            int penny = (cost%5);
            System.out.println(quarter+" "+dime+" "+nickel+" "+penny);
        }
    }
}