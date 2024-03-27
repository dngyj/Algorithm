import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] nums = new int[N];

        int max = 0;

        for(int i =0;i<N;i++){
            nums[i] = sc.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<>();

        int sum =0;
        for(int i=0;i<X;i++){
            sum+=nums[i];
        }
        max = sum;
        map.put(sum,map.getOrDefault(max,0)+1);

        for(int ed=X;ed<N;ed++){
            int st = ed-X;
            sum -= nums[st];
            sum += nums[ed];
            max = Math.max(sum,max);
            map.put(sum,map.getOrDefault(max,0)+1);
        }

        if(max==0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(map.get(max));
        }
    }
}