function solution(str1, str2) {
    let answer = '';
    
    let idx1 = 0;
    let idx2 = 0;
    let flag1 = false;
    let flag2 = false;
    while(idx1!==str1.length&&idx2!==str2.length){
        answer+=str1[idx1];
        answer+=str2[idx2];

        if(idx1<str1.length){
            idx1++;
        }
        if(idx2<str2.length){
            idx2++;
        }
    }

    
    return answer;
}