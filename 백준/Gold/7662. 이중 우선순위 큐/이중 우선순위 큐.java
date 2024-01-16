import java.util.PrimitiveIterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=0;tc<T;tc++){
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = sc.nextInt();

            for(int i = 0; i<k;i++){
                String command = sc.next();
                int num = sc.nextInt();

                if(command.equals("I")){
                    map.put(num, map.getOrDefault(num,0)+1);
                }
                if(command.equals("D")){
                    int out = 0;
                    if(num==-1&&!map.isEmpty()){
                        out = map.firstKey();
                    }
                    if(num==1&&!map.isEmpty()){
                        out = map.lastKey();
                    }
                    if(!map.isEmpty()&&map.put(out, map.get(out)-1)==1){
                        map.remove(out);
                    }
                }
            }
            if(map.isEmpty()) System.out.println("EMPTY");
            else{
                System.out.println(map.lastKey()+" "+map.firstKey());
            }
        }
    }
}