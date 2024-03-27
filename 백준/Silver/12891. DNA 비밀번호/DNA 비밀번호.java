import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int P = sc.nextInt();
        String dna = sc.next();
        int[] target = new int[4];
        for(int i =0;i<4;i++){
            target[i] = sc.nextInt();
        }
        int[] cnts = new int[4];
        int ans = 0;
        for(int i = 0;i<P;i++) {
            if (dna.charAt(i) == 'A') cnts[0]++;
            if (dna.charAt(i) == 'C') cnts[1]++;
            if (dna.charAt(i) == 'G') cnts[2]++;
            if (dna.charAt(i) == 'T') cnts[3]++;
        }

        boolean flag = false;
        for(int i =0;i<4;i++){
            if(cnts[i]<target[i]){
                flag = true;
                break;
            }
        }
        if(!flag) ans++;

        for(int ed=P; ed<S;ed++){
            int st = ed-P;
            if (dna.charAt(st) == 'A') cnts[0]--;
            if (dna.charAt(st) == 'C') cnts[1]--;
            if (dna.charAt(st) == 'G') cnts[2]--;
            if (dna.charAt(st) == 'T') cnts[3]--;

            if (dna.charAt(ed) == 'A') cnts[0]++;
            if (dna.charAt(ed) == 'C') cnts[1]++;
            if (dna.charAt(ed) == 'G') cnts[2]++;
            if (dna.charAt(ed) == 'T') cnts[3]++;

            flag = false;
            for(int i =0;i<4;i++){
                if(cnts[i]<target[i]){
                    flag = true;
                    break;
                }
            }
            if(!flag) ans++;
        }
        System.out.println(ans);
    }
}