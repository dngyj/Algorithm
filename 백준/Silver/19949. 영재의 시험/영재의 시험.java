import java.util.Scanner;

public class Main {
    static int[] ans;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ans = new int[10];
        for(int i = 0; i<10;i++){
            ans[i] = sc.nextInt();
        }
        cnt = 0;
        backTracking(0,0,new int[10]);
        System.out.println(cnt);
    }
    static void backTracking(int ansCnt, int idx, int[] jjik){
        if(idx==10){
            if(ansCnt>=5){
                cnt++;
            }
        }
        else{
            int ban = 0;
            if(idx>=2){
                if(jjik[idx-1]==jjik[idx-2]){
                    ban = jjik[idx-1];
                }
            }
            for(int i = 1;i<=5;i++){
                if(i == ban) continue;

                jjik[idx] = i;
                if(ans[idx]==i){
                    backTracking(ansCnt+1,idx+1,jjik);
                }
                else{
                    backTracking(ansCnt,idx+1,jjik);
                }
                jjik[idx] = 0;

            }
        }
    }
}