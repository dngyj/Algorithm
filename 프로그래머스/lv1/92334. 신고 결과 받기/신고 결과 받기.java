import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        //신고당한 ID, 이용자 ID HashSet
        Map<String, HashSet<String>> reportedIDs = new HashMap<>();

        //결과값
        int[] answer = new int[id_list.length];

        //이용자 id, '처리 결과 메일 수신 카운트 배열' 인덱스 맵을 만든다.
        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0 ; i < id_list.length ; i++) {
            idIndexMap.put(id_list[i], i);
        }

        
        for (int i = 0 ; i < report.length ; i++) {
            String[] reported = report[i].split(" "); // 이용자 신고자 구분
            if (reportedIDs.get(reported[1]) == null) { // 신고자 null이면
                    reportedIDs.put(reported[1], new HashSet<String>() );
                }
            HashSet<String> set = reportedIDs.get(reported[1]);
            set.add(reported[0]); 
            reportedIDs.put(reported[1], set);
        }

        //해당 신고자 신고한 이용자 카운트
        for (int i = 0 ; i < id_list.length ; i++) { 
            Set<String> reporterIDs = reportedIDs.get(id_list[i]);
            if (reporterIDs != null && reporterIDs.size() >= k) {
                Iterator<String> iter = reporterIDs.iterator();
                while(iter.hasNext()) {
                    String reporter = iter.next();
                    answer[idIndexMap.get(reporter)]++;
                }
            }
        }

        return answer;

    }
}