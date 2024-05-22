import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String game = sc.next();

        int needPeople = 0;
        if(game.equals("Y")) needPeople = 1;
        if(game.equals("F")) needPeople = 2;
        if(game.equals("O")) needPeople = 3;

        Set<String> set = new HashSet<>();
        for(int i = 0;i<N;i++){
            String name =sc.next();
            set.add(name);
        }
        System.out.println(set.size()/needPeople);
    }
}