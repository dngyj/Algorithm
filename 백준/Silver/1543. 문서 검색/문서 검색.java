import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String docs = sc.nextLine();
        String word = sc.nextLine();

        int cnt = 0;
        docs = docs.replaceAll(word,"0");

        for(int i = 0;i<docs.length();i++){
            if(docs.charAt(i)=='0') cnt++;
        }
        System.out.println(cnt);

    }
}