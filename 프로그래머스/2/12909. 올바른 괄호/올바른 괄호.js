function solution(s){
    var answer = true;
    
    let stack = new Stack();
    for(let i = 0; i<s.length;i++){
        let str = s.charAt(i)
        if(str==='('){
            stack.push(str);
        }
        else{
            if(stack.peek()=='(') stack.pop();
            else stack.push(str);
        }
    }
    
    if(stack.isEmpty()) answer = true;
    else answer = false;

    return answer;
}

class Stack{
    constructor(){
        this.arr = [];
    }
    push(item){
        this.arr.push(item);
    }
    pop(){
        return this.arr.pop();
    }
    peek(){
        return this.arr[this.arr.length-1];
    }
    isEmpty(){
        return this.arr.length===0;
    }
}