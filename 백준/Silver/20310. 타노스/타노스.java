import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.next().toCharArray();
        int zeroCnt = 0;
        int oneCnt = 0;

        for(int i = 0; i<ch.length;i++){
            if(ch[i]=='0') zeroCnt++;
            if(ch[i]=='1') oneCnt++;
        }

        int idx = 0;
        int cnt = 0;
        while(cnt<oneCnt/2){
            if(ch[idx]=='1'){
                cnt++;
                ch[idx] = '2';
            }
            idx++;
        }

        idx = ch.length-1;
        cnt = 0;
        while(cnt<zeroCnt/2){
            if(ch[idx]=='0'){
                cnt++;
                ch[idx] = '2';
            }
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<ch.length;i++){
            if(ch[i]=='0'||ch[i]=='1') sb.append(ch[i]);
        }
        System.out.println(sb.toString());
    }
}