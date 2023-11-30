import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X, Y;

        X = sc.nextLong();
        Y = sc.nextLong();

        long Z = 100 * Y / X;

        if (Z >= 99) {
            System.out.println(-1);
        } else {

            long start = 0;
            long end = 2000000000;

            while (start < end) {
                long mid = (start + end) / 2;

                long ret = 100 * (Y + mid) / (X + mid);

                if (ret > Z) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println(end);
        }
    }
}