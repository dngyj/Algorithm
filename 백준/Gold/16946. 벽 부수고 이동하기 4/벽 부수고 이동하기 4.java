import java.util.*;

public class Main {
    static int N,M;
    static char[][] map;
    static int[][] group;
    static Map<Integer,Integer> groupSize = new HashMap<>();
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static ArrayList<int[]> list1 = new ArrayList<>();
    static ArrayList<int[]> list0 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        group = new int[N][M];
        for(int r=0;r<N;r++){
            String str = sc.next();
            for(int c=0;c<M;c++){
                map[r][c] = str.charAt(c);
                if(map[r][c]=='1'){
                    list1.add(new int[]{r, c});
                }
                if(map[r][c]=='0'){
                    list0.add(new int[]{r, c});
                }
            }
        }

        int groupCnt=1;
        for(int[] zero : list0){
            int r = zero[0];
            int c = zero[1];
            if(group[r][c]==0){
                groupSize.put(groupCnt, bfs(r,c,groupCnt));
                groupCnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(group[r][c]==0) {
                    sb.append(count(r,c)+"");
                    continue;
                }
                sb.append(0+"");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int count(int r, int c){
        int cnt =1;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<4;i++){
            int idr = r+dr[i];
            int idc = c+dc[i];
            if(idr<0||idc<0||idr>=N||idc>=M) continue;
            if(group[idr][idc]==0) continue;
            set.add(group[idr][idc]);
        }
        for(int size:set){
            cnt+=groupSize.get(size);
        }
        return cnt%10;
    }


    static int bfs(int row, int col, int groupCnt){
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        group[row][col] = groupCnt;

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];

            for(int i=0;i<4;i++){
                int idr = r+dr[i];
                int idc = c+dc[i];
                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(group[idr][idc]==0&map[idr][idc]=='0') {
                    group[idr][idc] = groupCnt;
                    cnt++;
                    queue.add(new int[]{idr,idc});
                }
            }
        }
        return cnt;
    }
}