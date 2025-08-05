import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String words = sc.nextLine();
        String lowerWords = words.toLowerCase();

        int space_count = sc.nextInt();
        int[] alphabet_count = new int[26];
        for(int i = 0; i<26; i++){
            alphabet_count[i] = sc.nextInt();
        }

        char prev='1';

        for(int i = 0; i<words.length(); i++){
            char lower_word = lowerWords.charAt(i);
            char origin_word = words.charAt(i);

            if(prev==origin_word) continue;

            if(origin_word==' '){
                if(space_count<=0){
                    System.out.println(-1);
                    return;
                }
                space_count--;
            }
            else {
                int idx = lower_word-'a';
                if(alphabet_count[idx]<=0){
                    System.out.println(-1);
                    return;
                }
                alphabet_count[idx]--;
            }
            prev = origin_word;
        }

        String upperWords = words.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int idx = lowerWords.charAt(0)-'a';
        if(alphabet_count[idx]>0){
            sb.append(upperWords.charAt(0));
        } else {
            System.out.println(-1);
            return;
        }

        prev = words.charAt(0);
        for(int i = 1; i<words.length(); i++){
            char word = words.charAt(i);
            int index = lowerWords.charAt(i)-'a';
            if(prev==' '&&word!=' '){
                if(alphabet_count[index]<=0){
                    System.out.println(-1);
                    return;
                }
                sb.append(upperWords.charAt(i));
            }
            prev = word;
        }
        System.out.println(sb.toString());
    }
}
