import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 0 ; tc<T;tc++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int diff = ed-st;
            if(diff<=2) {
                System.out.println(diff);
            }
            else{
                calcaluateMin(diff);
            }
        }
    }
    
    static void calcaluateMin(int diff){
        int max = (int)Math.sqrt(diff);

        if(max == Math.sqrt(diff)) {
            System.out.println(max * 2 - 1);
        }
        else if(diff <= max * max + max) {
            System.out.println(max * 2);
        }
        else {
            System.out.println(max * 2 + 1);
        }
    }
}