import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static class Member implements Comparable<Member>{

		int num;
		int age;
		String name;
		
		public Member(int num, int age, String name) {
			super();
			this.num = num;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member o) {
			if(this.age == o.age) {
				return this.num - o.num;
			}
			return this.age - o.age;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Member> list = new ArrayList<>();
		
		int N = sc.nextInt();
		
		for(int i = 0; i<N;i++) {
			int age = sc.nextInt();
			String name = sc.next();
			list.add(new Member(i, age, name));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i<N;i++) {
			if(list.get(i)!= null) {
				System.out.println(list.get(i).age + " "+list.get(i).name);
			}
		}
		
	}

}