class Solution {
    
    static int[] picks;
    static String[] minerals;
    static int[] selected;
    static int[] visited;
    static int picks_sum = 0;
    static int min_fatigue = Integer.MAX_VALUE;
    static int[][] fatigue_types = {{1, 1, 1},{5, 1, 1},{25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        this.picks = picks;
        this.minerals = minerals;
        visited = new int[picks.length];
        
        for(int i = 0; i<picks.length; i++){
            picks_sum+=picks[i];
            visited[i] = picks[i];
        }
        
        selected = new int[picks_sum];
        perm(0);
        
        return min_fatigue;
    }
    
    static int mining(int[] selected){
        int mine_point = 0;
        int pick_point = 0;
        int pick_count = 0;
        
        int fatigue = 0;
        
        while(mine_point<minerals.length&&pick_point < selected.length){
            int pick_option = selected[pick_point];
            
            if(minerals[mine_point].equals("diamond")){
                fatigue+=fatigue_types[pick_option][0];
            }
            else if(minerals[mine_point].equals("iron")) {
                fatigue+=fatigue_types[pick_option][1];
            }
            else if(minerals[mine_point].equals("stone")){
                fatigue+=fatigue_types[pick_option][2];
            }
            
            mine_point++;
            pick_count++;
            if(pick_count>=5) {
                pick_count = 0;
                pick_point++;
            }
        }
        return fatigue;
    }
    
    static void perm(int idx){
        if(idx == picks_sum){
            min_fatigue = Math.min(mining(selected), min_fatigue);
        }
        else{
            for(int i = 0; i<picks.length; i++){
                if(visited[i]==0) continue;
                selected[idx] = i;
                visited[i]--;
                perm(idx+1);
                visited[i]++;
            }
        }
    }
}