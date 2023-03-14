import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int price = 0;

		if (a == b && b == c && c == a) {
			price = 10000 + a * 1000;
		} else if (a == b ) {
			price = 1000+ a*100;
		} else if (c == a) {
			price = 1000+ a*100;
		} else if (b == c) {
			price = 1000+ b*100;
		}else {
			int max =a;
			if(b>max) max =b;
			if(c>max) max = c;
			price = max*100;
		}
		
		System.out.println(price);
			

	}

}