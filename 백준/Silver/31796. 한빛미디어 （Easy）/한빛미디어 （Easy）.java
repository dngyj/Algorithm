import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] books = new int[N];
        for(int i = 0; i<N;i++){
            books[i] = sc.nextInt();
        }
        Arrays.sort(books);

        int page = 0;
        int key = 0;
        for(int i = 0; i<N;i++){
            if(books[i]>=2*key) {
                key = books[i];
                page++;
            }
        }
        System.out.println(page);
    }
}