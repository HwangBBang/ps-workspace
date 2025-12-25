// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];

        if (n >= 1) {
            dp[1] = wine[1];
        }
        if (n >= 2) {
            dp[2] = dp[1] + wine[2];
        }
        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                int choice1 = dp[i - 1]; // i 선택 X
                int choice2 = wine[i] + dp[i - 2]; // i 선택 O, i - 1 선택 X
                int choice3 = wine[i] + wine[i - 1] + dp[i - 3]; // i,i-1 선택 O, i - 2 선택 X
                dp[i] = Math.max(choice3, Math.max(choice1, choice2));
            }
        }

        System.out.println(dp[n]);

    }

}

/*
       _ _ _ _
       여럿을 선택한다.
       연장 3개 이상을 선택할 수 없다.
       2개를 선택했다면 다음하나는 무조건 점프해야한다.

        0, 6, 10, 13, 9, 8, 1
           T  T       T  T
        만큼의 포도주가 들어 있을 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
            i-2  i-1  i
        _ _  O    O   O ( 불가능 )
        _ _  O    O   X ( 안막힘 )
        _ _  O    X   X ( 안막힘 )
        _ _  X    X   X (최대 일 수 없음)
        _ _  X    X   O (최대 일 수 없음)

        _ _  X    O|   X
        _ _  | O    X   O
        _ _  X    O   O

*/