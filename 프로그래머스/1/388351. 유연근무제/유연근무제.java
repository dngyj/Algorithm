class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        int saturday = (6-startday);
        if(saturday == -1) saturday = 6;
        int sunday = (7-startday);   

        for(int i = 0; i<schedules.length; i++){
            int time = schedules[i];
            int[] timelog = timelogs[i];
            boolean flag = true;
            
            int hopeHour = time/100;
            int hopeMin = time%100+10;
            if(hopeMin>=60) {
                hopeMin-=60;
                hopeHour++;
            }
            int hopeTime = hopeHour*100+hopeMin;
            
            for(int day = 0; day<7; day++){
                if(day == saturday || day == sunday) continue;
                if(timelog[day]>hopeTime) flag = false;
            }
            
            if(flag) answer++;
        }
        return answer;
    }
}