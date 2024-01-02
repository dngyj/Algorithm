import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] belt = new int[N*2];
        int[] temp = new int[N*2];
        boolean[] robot = new boolean[N*2];
        boolean[] tempR = new boolean[N*2];
        for(int i = 0;i<N*2;i++){
            belt[i] = sc.nextInt();
        }

        int stage = 0;
        while(true){
            stage++;
            //1 벨트
            for(int i = 0; i<2*N;i++) {
                temp[i] = belt[i];
            }
            for(int i = 0;i<N;i++){
                tempR[i] = robot[i];
            }
            belt[0] = temp[2*N-1];
            for(int i = 1;i<2*N;i++){
                belt[i] = temp[i-1];
            }
            robot[0] = false;
            for(int i = 1;i<N;i++){
                robot[i] = tempR[i-1];
            }
            robot[N-1] = false;
            //2 로봇이동
            for(int i = N-2; i>=0;i--){
                if(robot[i]) {
                    if(belt[i+1]>=1&&!robot[i+1]){
                        robot[i] = false;
                        robot[i+1] = true;
                        belt[i+1]--;
                    }
                }
                if(i+1==N-1&&robot[i+1]) {
                    robot[i+1] = false;
                }
            }
            //3. 올리기
            if(belt[0]>=1) {
                robot[0] = true;
                belt[0]--;
            }

            //4. 종료조건
            int cnt =0;
            for(int i = 0; i<2*N;i++){
                if(belt[i]<=0) cnt++;
            }
            if(cnt>=K) break;
        }
        System.out.println(stage);
    }
}