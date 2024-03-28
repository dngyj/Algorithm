import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();

        int[] sushis = new int[N+k-1];

        for(int i = 0;i<N;i++){
            sushis[i] = sc.nextInt();
        }
        for(int i = N;i<N+k-1;i++){
            sushis[i] = sushis[i-N];
        }
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(sushis[i], map.getOrDefault(sushis[i],0)+1);
        }
        map.put(c, map.getOrDefault(c,0)+1);
        max = map.size();

        for(int ed=k;ed<N+k-1;ed++){
            int cnt =0;
            int st = ed-k;
            int remove = sushis[st];
            map.put(remove,map.get(remove)-1);
            if(map.get(remove)==0) map.remove(remove);

            int add = sushis[ed];
            map.put(add, map.getOrDefault(add,0)+1);
            map.put(c, map.getOrDefault(c,0)+1);

            cnt = map.size();
            max = Math.max(cnt, max);
        }
        System.out.println(max);
    }
}