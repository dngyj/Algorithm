import java.util.*;
import java.io.*;

public class Main {
    public static int[][] map = {{0,1},{2,3}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2,n);
        rec(r,c,size,0);
    }
    public static void rec(int r, int c, int len, int num){
        if(len>2) {
            len /= 2;
            if (r >= len && c >= len) // 3사분면
                rec(r % len, c % len, len, num+len*len*3);
            else if (r >= len && c < len) //2사분면
                rec(r % len, c, len, num+len*len*2);
            else if (r < len && c >= len) //4사분면
                rec(r, c % len, len, num+len*len*1);
            else // 1사분면
                rec(r, c, len, num);
        }
        else{
            System.out.println(map[r][c]+num);
        }
    }
}