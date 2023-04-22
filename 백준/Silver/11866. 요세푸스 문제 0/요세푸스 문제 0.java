import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) q.add(i);
		
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			int temp = q.poll();
			if(cnt % K == 0) list.add(temp);
			else q.add(temp);
		}
		
		System.out.println(list.toString().replace("[", "<").replace("]", ">"));
	}
}