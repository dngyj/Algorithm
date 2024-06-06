import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=0;tc<T;tc++){
            N = sc.nextInt();
            dfs(1,1,1, -1,1,"1");
            System.out.println();
        }
    }

    static void dfs(int idx, int num, int chknum, int chkOper,int result, String s){

        int length = s.length();

        if(length==2*N-1){
            if(result == 0){
                System.out.println(s);
            }
        }

        else {
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    num = num*10+idx+1;
                    int tempResult = num;
                    if(chkOper==1) tempResult = chknum-num;
                    else if(chkOper==0) tempResult = chknum+num;

                    dfs(idx+1,num, chknum, chkOper,tempResult,s + " "+(idx+1));
                }
                if (i == 1) {
                    int tempResult = result + idx+1;
                    dfs(idx + 1, idx+1, result, 0,tempResult, s + "+"+(idx+1));
                }
                if (i == 2) {
                    int tempResult = result - (idx+1);
                    dfs(idx + 1, idx+1, result,1,tempResult,s + "-"+(idx+1));
                }

            }
        }
    }
}