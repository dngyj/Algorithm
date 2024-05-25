import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> input = new ArrayList<>();
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            input.add(br.readLine());
        }

        for(int i = 0; i < input.size(); i++) {
            for(int j = 0; j < input.get(i).length(); j++) {
                if(i % 2 == 0) {
                    if(j % 2 == 0 && input.get(i).charAt(j) == 'F') {
                        count++;

                    }
                } else {
                    if(j % 2 != 0 && input.get(i).charAt(j) == 'F') {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

}