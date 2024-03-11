import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int ans = a.length();
        for(int i=0;i<b.length()-a.length()+1;i++){
            int temp = 0;
            for(int j=0;j<a.length();j++){
                if(a.charAt(j) != b.charAt(i+j)) temp++;
            }
            if(ans>temp){
                ans = temp;
            }
        }
        System.out.println(ans);
    }
}