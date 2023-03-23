import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	StringBuilder sb = new StringBuilder();
	
	String str = sc.next();

	String[] minusSplit = str.split("-");
	
	int result =0;
	
	for(int i =0; i<minusSplit.length;i++) {
		
		String[] addSplit = minusSplit[i].split("\\+");
		
		int addSum = 0;
		
		for(int j= 0;j<addSplit.length;j++) {
			addSum += Integer.parseInt(addSplit[j]);
		}
		
		if(i==0) {
			result = addSum;
		}else
		result -=addSum;
		
	}
	System.out.println(result);
	}
}