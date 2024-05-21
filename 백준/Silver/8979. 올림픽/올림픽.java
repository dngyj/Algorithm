import java.util.*;

public class Main {

    static class Country implements Comparable<Country>{
        int num;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Country(int num, int gold, int silver, int bronze, int rank){
            this.num = num;
            this.gold =gold;
            this.silver=silver;
            this.bronze=bronze;
            this.rank = rank;
        }

        @Override
        public int compareTo(Country c){
            if(gold == c.gold){
                if(silver==c.silver) return c.bronze-bronze;
                else return c.silver-silver;
            }
            else return c.gold-gold;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Country> list = new LinkedList<>();
        for(int i = 0; i<N;i++){
            int num = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();
            list.add(new Country(num,gold,silver,bronze, 0));
        }
        Collections.sort(list);
        list.get(0).rank = 1;

        int targetIdx = 0;
        for(int i = 1; i<list.size();i++){
            Country now = list.get(i);

            int preG = list.get(i-1).gold;
            int preS = list.get(i-1).silver;
            int preB = list.get(i-1).bronze;

            if(list.get(i).num==K) targetIdx = i;

            if(now.gold==preG&&now.silver==preS&&now.bronze==preB){
                list.get(i).rank = list.get(i-1).rank;
            }
            else list.get(i).rank = i+1;
        }
        System.out.println(list.get(targetIdx).rank);
    }

}