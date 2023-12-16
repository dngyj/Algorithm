import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int T = (int)Math.round(N*0.15);

        double sum = 0;
        for(int i=T; i<N-T;i++){
            sum+=arr[i];
        }
        System.out.println((int)Math.round(sum/(N-2*T)));

    }


}