// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> plus = new ArrayList<>();   // 2 이상 양수
        List<Integer> minus = new ArrayList<>();  // 음수
        int ones = 0;                             // 1의 개수
        int zeros = 0;                            // 0의 개수

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 1) plus.add(num);
            else if (num == 1) ones++;
            else if (num == 0) zeros++;
            else if (num < 0) minus.add(num);
        }


        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        long answer = 0;

        for (int i = 0; i < plus.size(); i += 2) {
            if (i + 1 < plus.size()) {
                answer += (long) plus.get(i) * plus.get(i + 1);
            } else {
                answer += plus.get(i);
            }
        }

        for (int i = 0; i < minus.size(); i += 2) {
            if (i + 1 < minus.size()) {
                answer += (long) minus.get(i) * minus.get(i + 1);
            } else {
                //하나남을 때
                if (zeros != 0) {
//                    0 이랑처리
                    zeros--;
                } else {
                    answer += minus.get(i);
                }
            }
        }
        answer += ones;

        System.out.println(answer);
    }

}

/*
*/