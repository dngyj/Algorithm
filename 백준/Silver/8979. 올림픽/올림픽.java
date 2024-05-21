import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Country implements Comparable<Country>{
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze){
            this.num = num;
            this.gold =gold;
            this.silver=silver;
            this.bronze=bronze;
        }

        @Override
        public int compareTo(Country c){
            if(gold>c.gold) {
                return -1;
            }else if(silver > c.silver){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        PriorityQueue<Country> queue = new PriorityQueue<>();
        for(int i = 0; i<N;i++){
            int num = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();
            queue.add(new Country(num,gold,silver,bronze));
        }

        int count = 0;
        Country temp = new Country(-1,-1,-1,-1);
        while(!queue.isEmpty()){
            count++;
            Country now = queue.poll();
            if(K==now.num){
                if(temp.gold==now.gold&&temp.silver==now.silver&&temp.bronze==now.bronze) count --;
                System.out.println(count);
                return;
            }
            temp = new Country(now.num, now.gold,now.silver,now.bronze);
        }
    }
}