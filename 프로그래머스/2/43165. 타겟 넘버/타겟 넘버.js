let cnt = 0;

function solution(numbers, target) {
    var answer = 0;
    dfs(numbers, target, 0, 0);
    answer = cnt;
    return answer;
}

function dfs(numbers, target, index, sum){
    if(index==numbers.length){
        if(sum==target) cnt++;
        return;
    }
    else{
        dfs(numbers, target, index+1, sum+numbers[index]);
        dfs(numbers, target, index+1, sum-numbers[index]);
    }
}