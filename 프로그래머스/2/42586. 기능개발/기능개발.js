function solution(progresses, speeds) {
    var answer = [];
    
    let queue = new Queue();
    
    for(let i = 0; i<progresses.length;i++){
        queue.add(i);
    }
    
    
    while(!queue.isEmpty()){
        let cnt = 0;
        for(let i = 0; i<progresses.length;i++){
            progresses[i] += speeds[i];
        }
        for(let i = 0; i<progresses.length;i++){
            if(progresses[i]>=100&&queue.firstpeek()==i){
                queue.poll();
                cnt++;
            }
        }
        if(cnt>0) answer.push(cnt);
    }
    return answer;
}

class Node{
    constructor(index, progress){
        this.index = index;
        this.progress = progress;
    }
}

class Queue{
    constructor(){
        this.arr = [];
    }
    poll(){
        return this.arr.shift();
    }
    firstpeek(){
        return this.arr[0];
    }
    add(item){
        this.arr.push(item);
    }
    isEmpty(){
        return this.arr.length==0;
    }
}