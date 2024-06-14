import java.io.*;
import java.util.*;

class Main {
	
	static ArrayList<Integer>[] list;
	static Scanner sc = new Scanner(System.in);
	
	static int N;
	static int[] p = new int[5];
	
	public static void main(String[] args){
		input();
		System.out.println(getMinTime());
	}
	
	static int getMinTime(){
		int minTime = 0;
		for(int i = 0; i<5;i++){
			Collections.sort(list[i]);
			
			for(int j = 0; j<p[i];j++){
				minTime+=list[i].get(j);
				if(j>=1){
					minTime+=(list[i].get(j)-list[i].get(j-1));
				}
			}
		}
		minTime += 240;
		return minTime;
	}
	
	static void input(){
		N = sc.nextInt();
		
		list = new ArrayList[5];
		for(int i = 0; i<5;i++){
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<5;i++){
			p[i] = sc.nextInt();
		}

		for(int i = 0; i<N;i++){
			int level = sc.nextInt()-1;
			int time = sc.nextInt();
			list[level].add(time);
		}
	}
}