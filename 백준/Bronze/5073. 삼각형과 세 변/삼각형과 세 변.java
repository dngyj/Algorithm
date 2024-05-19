import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int[] tri = new int[3];
            tri[0] = sc.nextInt();
            tri[1] = sc.nextInt();
            tri[2] = sc.nextInt();
            if(tri[0]==0&&tri[1]==0&&tri[2]==0) return;
            Arrays.sort(tri);
            if(tri[2]>=tri[0]+tri[1]) {
                System.out.println("Invalid");
                continue;
            }
            if(tri[0]==tri[1]&&tri[1]==tri[2]) System.out.println("Equilateral");
            else if(tri[0]==tri[1]||tri[1]==tri[2]||tri[0]==tri[2]) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }
}