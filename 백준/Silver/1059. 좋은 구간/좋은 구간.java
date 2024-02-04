import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] number = new int [size];
        for(int i=0; i<size; i++){
            number[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        Arrays.sort(number);
        int index = 0; 
        for(int num : number){
            if(n>num) {
                index++;
            }
        }
        int A = 0;
        if(index==0){
            A=0;
        }
        else {
            A = number[index-1];
        }
        int B = number[index];

        int sum = 0;
        for(int i=A+1; i<=n; i++){
            for(int j = n; j<B; j++){
                if(i==j) continue;
                else sum++;
            }
        }
        System.out.println(sum);
    }
}