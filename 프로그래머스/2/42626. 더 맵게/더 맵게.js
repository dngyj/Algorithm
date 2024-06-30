function solution(scoville, K) {
    var answer = 0;
    
    let heap = new MinHeap();
    
    for(let i =0;i<scoville.length;i++){
        heap.push(scoville[i]);
    }
    
    let count = 0;
    while(heap.size()>=2&&heap.peek()<K){
        let food1 = heap.pop();
        let food2 = heap.pop();
        
        let newFood = food1+food2*2;
        heap.push(newFood);
        count++;
    }
    answer = heap.peek()>=K ? count: -1;
    return answer;
}

class MinHeap{
    constructor(){
        this.heap = [];
    }
    
    size(){
        return this.heap.length;
    }
    
    push(item){
        this.heap.push(item);
        let index = this.heap.length-1;

        while(index > 0 
              && this.heap[index] < this.heap[Math.floor((index-1)/2)])
            {
                const temp = this.heap[index];
                this.heap[index] = this.heap[Math.floor((index-1)/2)];
                this.heap[Math.floor((index-1)/2)] = temp;
                
                index = Math.floor((index-1)/2);
            }
    }
    
    pop(){
        if(this.heap.length===0) return null;
        if(this.heap.length===1) return this.heap.pop();
        
        const minValue = this.heap[0];
        this.heap[0] = this.heap.pop();
        
        let index = 0;
        while(index*2+1 < this.heap.length){
            
            let minChildIndex = index * 2 + 2<this.heap.length 
            && this.heap[index*2+2] < this.heap[index*2+1]?index*2+2:index*2+1;
            
            if(this.heap[index] < this.heap[minChildIndex]){
                break;
            }
            
            const temp = this.heap[index];
            this.heap[index] = this.heap[minChildIndex];
            this.heap[minChildIndex] = temp;
            
            index = minChildIndex;
        }
        return minValue;
    }
    
    peek(){
        return this.heap[0];
    }
}