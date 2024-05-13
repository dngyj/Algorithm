import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int leaf = 0;
        if(M==2) leaf = 1;

        int lastLeaf = 0;
        for(int i =1;i<N;i++){
            if(M>leaf){
                leaf+=1;
                System.out.println(0+" "+i);
            }
            else{
                System.out.println(lastLeaf+" "+i);
            }
            lastLeaf = i;
        }
    }
}