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

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(sushis[i], map.getOrDefault(sushis[i],0)+1);
        }
        map.put(c, map.getOrDefault(c,0)+1);
        int max = map.size();

        for(int ed=k;ed<N+k-1;ed++){
            int cnt;
            int st = ed-k;
            int out = sushis[st];

            map.put(out,map.get(out)-1);
            if(map.get(out)==0) map.remove(out);

            int in = sushis[ed];

            map.put(in, map.getOrDefault(in,0)+1);
            map.put(c, map.getOrDefault(c,0)+1);

            cnt = map.size();
            max = Math.max(cnt, max);

        }
        System.out.println(max);
    }
}