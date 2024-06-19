import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static String[] levels;
    static int[] powers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        levels = new String[N];
        powers = new int[N];
        for(int i = 0; i<N;i++){
            st=new StringTokenizer(br.readLine());
            levels[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<M;i++){
           int score = Integer.parseInt(br.readLine());
           binarySearch(score);
        }
        System.out.println(sb.toString());
    }

    static void binarySearch(int score){
        int left = 0;
        int right = N-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(score<=powers[mid]){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        sb.append(levels[left]).append("\n");
    }
}