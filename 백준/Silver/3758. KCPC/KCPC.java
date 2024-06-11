import java.util.*;

public class Main {

    static class Team implements Comparable<Team>{
        int Id;
        int[] scoreList;
        int totalScore;
        int submitCnt;
        int lastSubmitTime;

        public int compareTo(Team o){
            if(o.totalScore==totalScore){
                if(o.submitCnt==submitCnt){
                    return lastSubmitTime-o.lastSubmitTime;
                }
                return submitCnt-o.submitCnt;
            }
            return o.totalScore-totalScore;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int myTeamID = sc.nextInt();
            int m = sc.nextInt();
            Team[] teams = new Team[n];

            for(int i = 0; i<m;i++){
                int teamID = sc.nextInt()-1;
                int problemNum = sc.nextInt();
                int score = sc.nextInt();

                if(teams[teamID] == null){
                    teams[teamID] = new Team();
                    teams[teamID].Id=teamID;
                    teams[teamID].scoreList=new int[k+1];
                }
                teams[teamID].scoreList[problemNum]=Math.max(score,teams[teamID].scoreList[problemNum]);
                teams[teamID].submitCnt++;
                teams[teamID].lastSubmitTime=i;
            }

            for(int i = 0;i<n;i++){
                int sum = 0;
                for(int j=1;j<k+1;j++){
                    sum+=teams[i].scoreList[j];
                }
                teams[i].totalScore = sum;
            }
            Arrays.sort(teams);

            for(int i = 0;i<n;i++){
                if(teams[i].Id==myTeamID-1) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}