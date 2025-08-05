import java.util.*;

public class Main {
    static class Team implements Comparable<Team>{
        int rank;
        int id;
        int school;
        Team(int rank, int id, int school){
            this.rank = rank;
            this.id = id;
            this.school = school;
        }

        @Override
        public int compareTo(Team o){
            return Integer.compare(this.rank, o.rank);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int C = sc.nextInt();

        int[] schoolCount = new int[N + 1];

        ArrayList<Team> result = new ArrayList<>();
        Queue<Team> overflow = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            int t = sc.nextInt();
            int s = sc.nextInt();

            if(schoolCount[s]<C){
                schoolCount[s]++;
                result.add(new Team(i, t, s));
            }
            else {
                overflow.add(new Team(i, t, s));
            }

            if(result.size()>=K){
                for(Team team : result){
                    System.out.println(team.id);
                }
                return;
            }
        }
        
        while(result.size()<K){
            result.add(overflow.poll());
        }

        Collections.sort(result);

        for(Team r : result){
            System.out.println(r.id);
        }
    }
}
