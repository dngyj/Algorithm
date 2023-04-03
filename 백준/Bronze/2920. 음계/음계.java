import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	
	Integer[] arr = new Integer[8];
	Integer[] num = new Integer[8];
	
	String result ="mixed";
	
	for(int i =0; i<8;i++) {
		num[i]=arr[i] = sc.nextInt();
	}
	
	Arrays.sort(arr);
	if(Arrays.equals(num, arr)) result = "ascending";
	Arrays.sort(arr, Collections.reverseOrder());
	if(Arrays.equals(num, arr)) result =  "descending";

	System.out.println(result);
	
	}

}