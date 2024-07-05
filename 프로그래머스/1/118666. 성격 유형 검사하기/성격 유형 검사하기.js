function solution(survey, choices) {

    let map = new Map();
    
    map.set('R',0);
    map.set('T',0);
    map.set('C',0);
    map.set('F',0);
    map.set('J',0);
    map.set('M',0);
    map.set('A',0);
    map.set('N',0);
    
    for(let i = 0; i<survey.length; i++){
        const type1 = survey[i].charAt(0);
        const type2 = survey[i].charAt(1);
        
        let score = choices[i];
        if(score>=4) {
            score = score-4;
            map.set(type2,map.get(type2)+score);
        }
        else{
            score = 4-score;
            map.set(type1,map.get(type1)+score);
        }
    }
    console.log(map);
    let answer = "";
    if(map.get('R')>=map.get('T')) answer+="R"
    else answer+="T"
    if(map.get('C')>=map.get('F')) answer+="C"
    else answer+="F"
    if(map.get('J')>=map.get('M')) answer+="J"
    else answer+="M"
    if(map.get('A')>=map.get('N')) answer+="A"
    else answer+="N"

    
    return answer;
}