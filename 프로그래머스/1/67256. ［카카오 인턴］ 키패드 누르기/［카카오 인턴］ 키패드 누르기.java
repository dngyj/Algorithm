class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left = -1;
        int right = -2;
        
        for(int i = 0;i<numbers.length;i++){
            int number = numbers[i];
            if(number == 1||number == 4||number == 7){
                left = number;
                answer+="L";
            }
            else if(number == 3||number == 6||number == 9){
                right = number;
                answer+="R";
            }
            else{
                if(getDistance(number, left)<getDistance(number, right)){
                    left = number;
                    answer+="L";
                }
                else if(getDistance(number, left)>getDistance(number, right)){
                    right = number;
                    answer+="R";
                }
                else{
                    if(hand.equals("left")){
                        left = number;
                        answer+="L";
                    }
                    else{
                        right = number;
                        answer+="R";
                    }
                }
            }
        }
        return answer;
    }
    
    static int getDistance(int number, int finger){
        int r = (number-1)/3;
        int c = (number-1)%3;
        if(number == 0){
            r=3;
            c=1;
        }
        int fingerR = (finger-1)/3;
        int fingerC = (finger-1)%3;
        if(finger == -1){
            fingerR=3;
            fingerC=0;
        }
        if(finger == -2){
            fingerR=3;
            fingerC=2;
        }
        if(finger == 0){
            fingerR=3;
            fingerC=1;
        }
        return Math.abs(r-fingerR)+Math.abs(c-fingerC);
    }
    
}