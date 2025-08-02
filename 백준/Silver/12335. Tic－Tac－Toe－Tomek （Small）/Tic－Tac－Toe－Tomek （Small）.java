import java.util.Scanner;

public class Main {
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 0; tc<T; tc++){
            map = new char[4][4];
            boolean isComplete = true;
            for(int r = 0; r<4; r++){
                String str = sc.next();
                for(int c = 0; c<4; c++){
                    if(str.charAt(c)=='.') isComplete = false;
                    map[r][c] = str.charAt(c);
                }
            }
            boolean isWinnerX = isWinner('O');
            boolean isWinnerO = isWinner('X');

            String result;
            if(isWinnerX) result = "X won";
            else if(isWinnerO) result = "O won";
            else if(isComplete) result = "Draw";
            else result = "Game has not completed";
            
            System.out.println("Case #"+(tc+1)+": "+result);
        }
    }

    static boolean isWinner(char opposite){
        for(int r = 0; r<4; r++){
            boolean isWin = true;
            for(int c = 0; c<4; c++){
                if(map[r][c]=='.'||map[r][c]==opposite) isWin=false;
            }
            if(isWin) return true;
        }

        for(int c = 0; c<4; c++){
            boolean isWin = true;
            for(int r = 0; r<4; r++){
                if(map[r][c]=='.'||map[r][c]==opposite) isWin=false;
            }
            if(isWin) return true;
        }

        boolean isWin = true;
        for(int r = 0; r<4; r++){
            if(map[r][r]=='.'||map[r][r]==opposite) isWin=false;
        }
        if(isWin) return true;

        isWin = true;
        for(int r = 0; r<4; r++){
            if(map[r][3-r]=='.'||map[r][3-r]==opposite) isWin=false;
        }
        if(isWin) return true;
        return false;
    }
}
