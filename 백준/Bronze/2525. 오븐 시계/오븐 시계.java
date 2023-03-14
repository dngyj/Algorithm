import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	
	int hour= sc.nextInt();
	int minute = sc.nextInt();
	int work = sc.nextInt();

	int rminute;
	
	rminute = (minute+work)%60;

	hour = hour+(minute+work)/60;
	
		if(hour>=24) {
			hour = hour-24;
		}
	
	System.out.println(hour+" "+rminute);
}
}