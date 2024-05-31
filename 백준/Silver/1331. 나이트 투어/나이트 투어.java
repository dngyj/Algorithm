import java.util.Scanner;

public class Main {

    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visited = new boolean[6][6];

        char[] start = sc.next().toCharArray();
        int startR = start[0]-65;
        int startC = start[1]-49;

        visited[startR][startC] = true;

        int preR = start[0]-65;
        int preC = start[1]-49;

        boolean isInvalid = false;
        for(int i = 0; i<35;i++){
            char[] cur = sc.next().toCharArray();
            int r = cur[0]-65;
            int c = cur[1]-49;

            if(!visited[r][c]&&isNight(preR, preC, r, c)){
                preR = r;
                preC = c;
                visited[r][c] = true;
            }
            else {
                isInvalid = true;
                break;
            }
        }

        if(!isNight(preR,preC,startR,startC)) isInvalid = true;

        if(isInvalid) System.out.println("Invalid");
        else System.out.println("Valid");
    }

    static boolean isNight(int preR, int preC, int r, int c){
        if (Math.abs(preR - r) == 2 && Math.abs(preC - c) == 1
                || Math.abs(preR - r) == 1 && Math.abs(preC - c) == 2)
            return true;
        return false;
    }
}