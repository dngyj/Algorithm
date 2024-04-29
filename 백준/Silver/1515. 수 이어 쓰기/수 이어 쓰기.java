import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int point= 0;
        int base = 1;
        while(point<str.length()){
            String tmp = Integer.toString(base);

            for(int i = 0;i<tmp.length();i++){
                if(tmp.charAt(i)==str.charAt(point)) point++;
                if(point >= str.length()) {
                    System.out.println(base);
                    break;
                }
            }
            base++;
        }
    }
}