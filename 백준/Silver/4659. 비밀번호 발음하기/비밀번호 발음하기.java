import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String word = sc.next();
            if(word.equals("end")) break;
            boolean highLevel = true;

            boolean check = false;
            for(int i = 0; i<word.length();i++){
                if(isParent(word.charAt(i))){
                    check = true;
                    break;
                }
            }
            if(!check) highLevel = false;

            for(int i = 0; i<word.length()-2;i++){
               if(isParent(word.charAt(i))&&isParent(word.charAt(i+1))&&isParent(word.charAt(i+2))){
                    highLevel = false;
               }
               if(!isParent(word.charAt(i))&&!isParent(word.charAt(i+1))&&!isParent(word.charAt(i+2))){
                   highLevel = false;
               }
            }

            for(int i = 0; i<word.length()-1;i++){
                if(word.charAt(i)==word.charAt(i+1)){
                    if(word.charAt(i)!='e'&&word.charAt(i)!='o') {
                        highLevel = false;
                    }
                }
            }

            if(highLevel) System.out.println("<"+word+">"+" is acceptable.");
            else System.out.println("<"+word+">"+" is not acceptable.");

        }

    }
    static boolean isParent(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') return true;
        else return false;
    }

}