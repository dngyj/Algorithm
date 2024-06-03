import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        br.close();

  
        for(int i = 2; i <= sqrt(N); i++){ 
            while(N%i == 0){
                N /= i;
                sb.append(i + "\n");
            }
        }

        if(N != 1){
            sb.append(N);
        }
        System.out.println(sb);
    }
}