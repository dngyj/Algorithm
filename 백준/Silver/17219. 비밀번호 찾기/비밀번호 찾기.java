import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> info = new HashMap<>();
        for(int i=0; i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();
            info.put(site, pw);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M;i++) {
            String keyword = br.readLine();
            sb.append(info.get(keyword)+"\n");
        }
        System.out.print(sb.toString());
    }

}