
function solution(maps) {
    var answer = -1;
    const N = maps.length;
    const M = maps[0].length;
    
    const dr = [-1,1,0,0];
    const dc = [0,0,-1,1];
    let visited = Array.from(Array(N), () => new Array(M).fill(false));

    
    bfs();
    
    function bfs(){
        let queue = new Queue();
        queue.add([0,0,1]);
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            const cur = queue.poll();
            
            const r = cur[0];
            const c = cur[1];
            const cnt = cur[2];
            
            if(r==N-1&&c==M-1){
                answer = cnt;
                break;
            }
            
            for(let d = 0; d<4;d++){
                let idr = r + dr[d];
                let idc = c + dc[d];
            
                if(idr<0||idc<0||idr>=N||idc>=M) continue;
                if(maps[idr][idc]===0) continue;
                if(visited[idr][idc]) continue;
                visited[idr][idc] = true;
                queue.add([idr, idc, cnt+1]);
            }
        }
    }
    
    return answer;
}



class Queue{
    constructor(){
        this.storage = {};
        this.head = 0;
        this.tail = 0;   
    }
    add(item){
        this.storage[this.tail++] = item;
    }
    poll(){
        let removed = this.storage[this.head];
        delete this.storage[this.head];
        this.head++;
        
        if(this.head===this.tail){
            this.head=0;
            this.tail=0;
        }
        return removed;
    }
    
    isEmpty(){
        return this.tail-this.head===0;
    }
}
