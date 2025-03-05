function solution(players, m, k) {
    let answer = 0;
    //1. 포문 돌기
    //2. i에 해당하는 현재 증설된 서버 수 저장 변수
    //3. 증설된 서버의 유효 시간
    let servers = new Array(24).fill(0);
    let count = 0;
    for(let i = 0; i<players.length; i++){
        let player = players[i];
        let needServer = Math.floor(player/m);
        let addServer = 0;
        // console.log(servers[i], needServer, servers[i] < needServer)
        if(servers[i]<needServer){
            addServer = needServer-servers[i];
            for(let t = i; t<k+i; t++){
                servers[t] += addServer;
            }
            count+=addServer;
        }
         // console.log(i+"~"+(i+1), player, servers[i], addServer)
    }
    answer = count;
    return answer;
}