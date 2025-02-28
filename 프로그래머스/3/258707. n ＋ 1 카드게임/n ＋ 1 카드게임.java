import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int N = cards.length;
        int target = N+1;
        
        HashSet<Integer> hands = new HashSet<>();
        HashSet<Integer> addCards = new HashSet<>();
        
        int endPoint = N/3;
        
        for(int i = 0; i<endPoint; i++){
            hands.add(cards[i]);
        }
        
        int round = 0;
        while(true){
            round++;
            if(endPoint>=N) break;
            addCards.add(cards[endPoint]);
            addCards.add(cards[endPoint+1]);
            endPoint+=2;
            
            boolean flag = false;
            
            for(int card:hands){
                if(hands.contains(target-card)){
                    hands.remove(card);
                    hands.remove(target-card);
                    flag = true;
                    break;
                }
            }
            
            if(flag) continue;
            if(coin>0){
                for(int card: hands){
                    if(addCards.contains(target-card)){
                        hands.remove(card);
                        addCards.remove(target-card);
                        coin--;
                        flag = true;
                        break;
                    }
                }
            }
            
            if(flag) continue;
            if(coin>1){
                for(int card: addCards){
                    if(addCards.contains(target-card)){
                        addCards.remove(card);
                        addCards.remove(target-card);
                        coin -= 2;
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) break;
        }
        return round;
    }
}