import java.util.Scanner;

public class Main {

    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new char[N][N];

        boolean flag = false;
        int headR = -1;
        int headC = -1;
        for(int r = 0;r<N;r++){
            String str = sc.next();
            for(int c=0;c<N;c++){
                map[r][c] = str.charAt(c);
                if(!flag&&map[r][c]=='*') {
                    headR=r;
                    headC=c;
                    flag=true;
                }
            }
        }
        int heartR = headR+1;
        int heartC = headC;

        int leftArm=0;
        int rightArm = 0;
        int waist=0;
        int leftLeg=0;
        int rightLeg=0;

        for(int c = heartC-1;c>=0;c--){
            if(map[heartR][c]=='*') leftArm++;
        }
        for(int c = heartC+1;c<N;c++){
            if(map[heartR][c]=='*') rightArm++;
        }
        for(int r = heartR+1;r<N;r++){
            if(map[r][heartC]=='*') waist++;
        }
        for(int r = heartR+1;r<N;r++){
            if(map[r][heartC-1]=='*') leftLeg++;
        }
        for(int r = heartR+1;r<N;r++){
            if(map[r][heartC+1]=='*') rightLeg++;
        }
        System.out.println((heartR+1)+" "+(heartC+1));
        System.out.println(leftArm+" "+rightArm+" "+waist+" "+leftLeg+" "+rightLeg);
    }
}