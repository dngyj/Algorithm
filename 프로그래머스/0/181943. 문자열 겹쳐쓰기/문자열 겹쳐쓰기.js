function solution(my_string, overwrite_string, s) {
    let answer = '';
    answer += my_string.substring(0, s);
    answer += overwrite_string;
    answer += my_string.substring(answer.length, my_string.length);
    return answer;
}