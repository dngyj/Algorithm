import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> set = new HashSet<>();
        for(int i = 0; i<N;i++){
            set.add(sc.next());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M;i++){
            String[] str = sc.next().split(",");
            for(int j=0;j<str.length;j++){
                String s = str[j];
                set.remove(s);
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb.toString());
    }
}