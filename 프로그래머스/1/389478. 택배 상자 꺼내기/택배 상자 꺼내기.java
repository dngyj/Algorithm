class Solution {
    public int solution(int n, int w, int num) {
        int h = n/w+1;
        int[][] boxes = new int[h][w];
        
        int seq = 1;
        outer: for(int r = 0; r<h; r++){
            for(int c = 0; c<w; c++){
                if(r%2==0) boxes[r][c] = seq++;
                else boxes[r][w-1-c] = seq++;
                if(seq>n) break outer;
            }
        }
        int count = 0;
        for(int r = 0; r<h; r++){
            for(int c = 0; c<w; c++){
                if(boxes[r][c]==num){
                    for(int k = r; k<h; k++){
                        if(boxes[k][c]!=0) count++;
                    }
                }
            }
        }
        return count;
    }
}