import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();


        ArrayList<String> arrayList = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        int cnt = 0;
        for (int j = 0; j < M; j++) {
            String str = sc.next();
            if (set.contains(str)) {
                arrayList.add(str);
                cnt++;
            }
        }

        Collections.sort(arrayList);

        System.out.println(cnt);
        for (String ans : arrayList)
            System.out.println(ans);

    }

}