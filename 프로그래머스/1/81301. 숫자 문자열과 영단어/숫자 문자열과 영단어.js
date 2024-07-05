function solution(s) {
    var answer = 0;
    
    const alpha = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    
    for(let i = 0; i<10; i++){
        s = s.replaceAll(alpha[i], i);
    }
    answer = Number(s);
    return answer;
}