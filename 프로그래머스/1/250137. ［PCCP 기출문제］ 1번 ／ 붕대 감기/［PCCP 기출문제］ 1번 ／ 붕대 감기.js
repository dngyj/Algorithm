function solution(bandage, health, attacks) {
    let answer = 0;
    let lastTime = 0;
    let nowHP = health;
    
    for(let i = 0; i<attacks.length; i++){
        const time = attacks[i][0];
        const damage = attacks[i][1];
        let interval = time-lastTime-1;
        let nextHP = nowHP+(interval * bandage[1])+Math.floor(interval/bandage[0])*bandage[2];
        
        lastTime = time;
        
        nowHP = nextHP > health ? health : nextHP;
        nowHP -= damage;
        if(nowHP<=0) return -1;
    }
    
    answer = nowHP;
    return answer;
}

