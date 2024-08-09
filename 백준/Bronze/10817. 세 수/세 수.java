import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            
            String text[] = rd.readLine().split(" ");
            int num[] = new int[3];
            
            for(int i=0;i<3;i++) {
                num[i] = Integer.parseInt(text[i]);
            }
            Arrays.sort(num);
            System.out.println(num[1]);
    }
}