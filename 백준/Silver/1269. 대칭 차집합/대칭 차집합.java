import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for(int i = 0; i<a;i++){
            setA.add(sc.nextInt());
        }
        for(int i = 0; i<b;i++){
            setB.add(sc.nextInt());
        }

        int ans = 0;
        for(int num:setA){
            if(!setB.contains(num)) ans++;
        }
        for(int num:setB){
            if(!setA.contains(num)) ans++;
        }
        System.out.println(ans);
    }

}