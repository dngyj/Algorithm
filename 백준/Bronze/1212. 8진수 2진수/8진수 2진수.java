import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;

	static String endl = "\n";
	static String blank = " ";
	
	static String num;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		num = br.readLine();
	}

	static void pro() throws IOException {
		String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};
		String str ="";
		str = String.valueOf(Integer.parseInt(binary[num.charAt(0)-'0']));
		sb.append(str);
		for (int i = 1; i < num.length(); i++) {
//			str += binary[num.charAt(i)-'0'];
			sb.append(binary[num.charAt(i)-'0']);
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

}