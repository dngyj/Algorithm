import java.util.*;

class Solution {
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] map;
    static int R,C;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        R = storage.length;
        C = storage[0].length();
        map = new char[R+2][C+2]; 
        
        for(int r = 0; r<R; r++){
            String str = storage[r];
            for(int c = 0; c<C; c++){
                map[r+1][c+1] = str.charAt(c);
            }
        }
        
        for(String request:requests){
            char target = request.charAt(0);
            if(request.length()==1){
                removeSideContainer(target);
            }
            else{
               removeAllContainer(target);
            }
        }
        
        int remove_count = 0;
        for(int r = 1; r<=R; r++){
            for(int c = 1; c<=C; c++){
                if(map[r][c]=='0'||map[r][c]=='1') {
                   // System.out.println("R :"+r+" C :"+c);
                    remove_count++;
                }
            }
        }
        answer = R*C - remove_count;
        return answer;
    }
    
    public void removeSideContainer(char target){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        
        ArrayList<int[]> removeList = new ArrayList<>();
        
        boolean[][] visited = new boolean[R+2][C+2];
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            
            for(int d = 0; d<4; d++){
                int idr = r+dr[d];
                int idc = c+dc[d];
                
                if(idr<0||idc<0||idr>=R+2||idc>=C+2) continue;
                if(visited[idr][idc]) continue;
                if(map[idr][idc]==target) {
                    removeList.add(new int[]{idr,idc});
                }
                if(map[idr][idc]==0||map[idr][idc]=='0'||map[idr][idc]=='1'){
                    visited[idr][idc] = true;
                    queue.add(new int[]{idr,idc});
                }
            }
        }
        
        for(int[] pos : removeList){
            int r = pos[0];
            int c = pos[1];
            map[r][c] = '0';
        }
    }
    
    public void removeAllContainer(char target){
        for(int r = 1; r<=R; r++){
            for(int c = 1; c<=C; c++){
                if(map[r][c]==target){
                    map[r][c] = '1';
                }
            }
        }
    }
}