import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		String s = str.replaceAll("XXXX", "AAAA");
		String result = s.replaceAll("XX", "BB");
		
		if(result.contains("X")) {
			result = "-1";
		}
		
		System.out.println(result);
	}

}