import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] record = new int[4][M];

        for(int i =0;i<N;i++){
            String dna = sc.next();
            for(int j = 0; j<M;j++){
                if(dna.charAt(j)=='A') record[0][j]++;
                if(dna.charAt(j)=='C') record[1][j]++;
                if(dna.charAt(j)=='G') record[2][j]++;
                if(dna.charAt(j)=='T') record[3][j]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int hd = 0;

        for(int i=0;i<M;i++){
            int max = -1;
            for(int k=0;k<4;k++){
                max = Math.max(max, record[k][i]);
            }
            if(max==record[0][i]) sb.append("A");
            else if(max==record[1][i]) sb.append("C");
            else if(max==record[2][i]) sb.append("G");
            else if(max==record[3][i]) sb.append("T");
            hd += N-max;
        }
        System.out.println(sb);
        System.out.println(hd);
    }
}