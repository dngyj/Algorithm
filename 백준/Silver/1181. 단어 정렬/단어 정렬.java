import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static class word implements Comparable<word> {
		String word;
		
		public word(String word) {
			super();
			this.word = word;
		}

		@Override
		public int compareTo(word o) {
			int result = Integer.compare(word.length(), o.word.length());
			if (result == 0) result = this.word.compareTo(o.word);
			return result;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<word> list = new ArrayList<word>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			list.add(new word(str));
		}
		Collections.sort(list);
		sb.append(list.get(0).word).append('\n');
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).word.equals(list.get(i-1).word)) continue;
			sb.append(list.get(i).word).append('\n');
		}
		System.out.println(sb);
	}
}