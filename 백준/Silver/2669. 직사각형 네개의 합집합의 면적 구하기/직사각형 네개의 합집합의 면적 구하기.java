import java.util.Scanner;

public class Main {

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[100][100];

        for(int i = 0;i<4;i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            paint(x1,y1,x2,y2);
        }
        System.out.println(countArea());
    }
    
    static void paint(int x1, int y1, int x2, int y2){
        for(int r=x1;r<x2;r++){
            for(int c=y1; c<y2;c++){
                map[r][c] = 1;
            }
        }
    }
    
    static int countArea(){
        int count = 0;
        for(int r=0;r<100;r++){
            for(int c=0; c<100;c++){
                if(map[r][c] == 1) count++;
            }
        }
        return count;
    }
}