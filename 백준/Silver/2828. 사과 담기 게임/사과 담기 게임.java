import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = 1;
        int end = start+M-1;
        int moveDist = 0;

        int j = sc.nextInt();
        for(int i = 0;i<j;i++){
            int num = sc.nextInt();
            if(num<start){
                while(num!=start){
                    start--;
                    end--;
                    moveDist++;
                }
            }
            if(num>end){
                while(num!=end){
                    start++;
                    end++;
                    moveDist++;
                }
            }
        }
        System.out.println(moveDist);
    }
}