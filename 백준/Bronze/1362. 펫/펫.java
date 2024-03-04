import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if(o == 0 && w == 0) break;
			
			int count = 0;
			
			while(true) {
				st = new StringTokenizer(br.readLine());
				String EF = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if(EF.equals("#") && n == 0) break;
				
				if(EF.equals("E")) w -= n;
				if(EF.equals("F")) w += n;
				
				if(w <= 0) {
					count = 1;
				}
			}
			if(count == 1){
				System.out.println(num + " RIP");
			}else {
				if((o / 2) < w && w < (o * 2)) {
				System.out.println(num + " :-)");
				}else {
				System.out.println(num + " :-(");
				}
			}
			num++;
		}
	}
}