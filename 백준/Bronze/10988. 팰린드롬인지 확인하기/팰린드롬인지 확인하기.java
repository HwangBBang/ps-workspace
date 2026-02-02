// package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/baekjoon/gold/bronze.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int n = word.length();
        int l = 0, r = n - 1;
        int answer = 1;
        
        while (l <= r){
            if (word.charAt(l) != word.charAt(r)) {
                answer = 0;
                break;
            }
            l ++;
            r --;
        }

        System.out.println(answer);

    }

}