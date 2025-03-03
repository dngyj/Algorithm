function solution(land) {
    let answer = 0;
    
    const dr = [-1,1,0,0];
    const dc = [0,0,-1,1];
    
    const R = land.length;
    const C = land[0].length;
    
    let maxAmount = -1;
    let amountOfPart = new Map();
    
    function bfs(st_r, st_c, part){
        let queue =[[st_r, st_c]];
        let max_cnt = 0;
        let cnt = 1;
        land[st_r][st_c] = part;
        
        while(queue.length>0){
            const now = queue.shift();
            const r = now[0];
            const c = now[1];

            max_cnt = cnt;
            
            for(let d = 0; d<4;d++){
                const idr = r+dr[d];
                const idc = c+dc[d];
                
                if(idr<0||idc<0||idr>=R||idc>=C) continue;
                if(land[idr][idc]===0) continue;
                if(land[idr][idc]===1){
                    land[idr][idc] = part;
                    queue.push([idr, idc]);
                    cnt++;
                }
            }
        }
        amountOfPart.set(part, max_cnt);
        return max_cnt;
    }
    
    
    let part = 2;
        for(let c = 0; c<C; c++){
        let count = 0;
        let parts = new Set();
        for(let r = 0; r<R; r++){
            if(land[r][c]===1){
                count += bfs(r, c, part);
                parts.add(part);
                part++;
            }
            else if(land[r][c]>1&&!parts.has(land[r][c])){
                count += amountOfPart.get(land[r][c]);
                parts.add(land[r][c]);
            }
        }
        maxAmount = Math.max(count, maxAmount);
    }
    answer = maxAmount;
    return answer;
}