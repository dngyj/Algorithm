import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=0;tc<T;tc++){
            String W = sc.next();
            int K = sc.nextInt();

            if(K==1){
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];
            for(int i=0;i<W.length();i++){
                alpha[W.charAt(i)-'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for(int i =0;i<W.length();i++){
                int idx = W.charAt(i)-'a';
                if(alpha[idx]<K) continue; // i에 해당하는 알파벳이 K보다 작으면 그냥 넘기기

                int cnt =1;

                //i 다음 ~ 끝까지 문자 탐색
                for(int k=i+1;k<W.length();k++){
                    if(W.charAt(i)==W.charAt(k)) cnt++; //시작점과 뒤에오는 문자 같은지 찾기
                    if(cnt == K){ //K번 찾아지면
                        min = Math.min(min, k-i+1);
                        max = Math.max(max,k-i+1);
                        break;
                    }
                }
            }
            if(min==Integer.MAX_VALUE||max ==-1) System.out.println(-1);
            else System.out.println(min+" "+max);
        }
    }
}