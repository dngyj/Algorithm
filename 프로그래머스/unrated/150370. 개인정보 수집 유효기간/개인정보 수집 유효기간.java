import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Integer> arrList = new ArrayList<Integer>();
      
        int termSize = terms.length;
        int privaciesSize = privacies.length;
        
        int[] answer = new int[privaciesSize];     
        
        for(int i = 0; i<termSize; i++){
            String str = terms[i];
            String[] strSplit = str.split("\\s");
            map.put(strSplit[0], Integer.parseInt(strSplit[1]));
        }
        
        for(int i = 0; i<privaciesSize; i++){
            
            String str = privacies[i];
            String[] strSplit = str.split("\\s");
            
            String date = strSplit[0];
            String type = strSplit[1];
            
            String[] dateSplit = date.split("\\.");
            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int day = Integer.parseInt(dateSplit[2]);
            
            // System.out.println(year+" "+month+" "+day);
            
            int expire = map.get(type); // 달 수
            
            year = year + expire/12;
            month = month + expire%12;
            day = day-1;
            
            if(day==0){
                day = 28;
                month--;
            }
            if(month<=0){
                year--;
            }
            if(month>12){
                month = month-12;
                year++;
            }
            
            
            // int expireMonth = expire-1;
            // int expireDay = 27;
         
//             if(day+expireDay>28){
//                 day = day+expireDay-28;
//                 month++;
//             }
//             else day+=expireDay;
            
//             if(month+expireMonth>12) {
//                 year++;
//                 month = month+expireMonth-12;
//             }
//             else month+=expireMonth;
            
            System.out.println(year+" "+month+" "+day);
            
            String[] todaySplit = today.split("\\.");
            int yearT = Integer.parseInt(todaySplit[0]);
            int monthT = Integer.parseInt(todaySplit[1]);
            int dayT = Integer.parseInt(todaySplit[2]);

            // System.out.println(yearT+" "+monthT+" "+dayT);
            if(year<yearT){
                arrList.add(i+1);
            }
            if(year==yearT&&month<monthT){
                arrList.add(i+1);
            }if(year==yearT&&month==monthT&&day<dayT){
                arrList.add(i+1);
            }
        }
        
        return arrList;
    }
}