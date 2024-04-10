import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N,K;
    static int[] bags;
    static long ans;
    static class Gemstone implements Comparable<Gemstone>{
        int weight;
        int cost;
        Gemstone(int weight, int cost){
            this.weight = weight;
            this.cost = cost;
        }
        @Override
        public int compareTo(Gemstone g){
            if(weight==g.weight) return g.cost-cost;
            return weight-g.weight;
        }
    }
    static PriorityQueue<Gemstone> gemstones = new PriorityQueue<>();

    public static void main(String[] args) {
        input();
        Arrays.sort(bags);
        findMaxSum();
        System.out.println(ans);
    }

    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        bags = new int[K];
        for(int i = 0;i<N;i++){
            int w = sc.nextInt();
            int c = sc.nextInt();
            gemstones.add(new Gemstone(w,c));
        }
        for(int i =0;i<K;i++){
            bags[i] = sc.nextInt();
        }
    }
    static void findMaxSum(){
        PriorityQueue<Gemstone> queue = new PriorityQueue<>(new Comparator<Gemstone>() {
            @Override
            public int compare(Gemstone o1, Gemstone o2) {
                return o2.cost - o1.cost;
            }
        });

        for(int i = 0;i<K;i++){
            while(!gemstones.isEmpty()&&gemstones.peek().weight<=bags[i]) queue.add(gemstones.poll());
            if(!queue.isEmpty()) ans+= queue.poll().cost;
        }
    }
}