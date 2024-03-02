import java.util.*;
import java.io.*;

public class Main {
    
	static int N, M;
	static int[][] map;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	
    	int sum = 0;
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] != 0) {
    				sum++;
    			}
    		}
    	}
    
    	sum *= 2;

    	for(int i=0; i<N; i++) {
    		for(int j=M-1; j>=1; j--) {
    			int space = map[i][j-1] - map[i][j]; 
    			if(space >= 0) { 
    				sum += space;
    			}
    		}
    		sum += map[i][M-1];
    	}

    	for(int i=0; i<N; i++) {
    		for(int j=0; j<=M-2; j++) {
    			int space = map[i][j+1] - map[i][j];
    			if(space >= 0) {
    				sum += space;
    			}
    		}
    		sum += map[i][0];
    	}
    	
    	for(int j=0; j<M; j++) {
    		for(int i=N-1; i>=1; i--) {
    			int space = map[i-1][j] - map[i][j];
    			if(space >= 0) {
    				sum += space;
    			}
    		}
    		sum += map[N-1][j];
    	}

    	for(int j=0; j<M; j++) {
    		for(int i=0; i<=N-2; i++) {
    			int space = map[i+1][j] - map[i][j];
    			if(space >= 0) {
    				sum += space;
    			}
    		}
    		sum += map[0][j];
    	}
    	
    	System.out.println(sum);
    }
	
}