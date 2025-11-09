
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;     
        dp[1] = 1;    

        for (int i = 2; i <= n; i++) {
            char c1 = s.charAt(i - 1);   // 현재 자리
            char c0 = s.charAt(i - 2);   // 직전 자리

            // 1) 현재 한 자리
            if (c1 != '0') {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }

            // 2) 직전+현재 두 자리 
            int two = (c0 - '0') * 10 + (c1 - '0');
            if (two >= 10 && two <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }

        System.out.println(dp[n] % MOD);
    }
}

/*
 A : 1  1개
 B : 2  1개
 C : 3  1개
 D : 4  1개
 E : 5  1개
 F : 6  1개
 G : 7  1개
 H : 8  1개
 I : 9  1개
 J : 10 1개
 K : 11 2개
 L : 12 2개
 M : 13 2개
 N : 14 2개
 O : 15 2개
 P : 16 2개
 Q : 17 2개
 R : 18 2개
 S : 19 2개
 T : 20 1개
 U : 21 2개
 V : 22 2개
 W : 23 2개
 X : 24 2개
 Y : 25 2개
 Z : 26 2개

 25114를 다시 영어로 바꾸면, "BEAAD", "YAAD", "YAN", "YKD", "BEKD", "BEAN"

 2 5 1 1 4
 B E A A D -> 1 + 1 + 1 + 1 + 1
  Y  A A D
  Y  A  N
  Y   K  D
 B E  K  D
 B E A  N


 1 => 1개
 dp[1] 은 무조건 1 이다.
 dp[2] 는 ?
 11 => 이전놈과 현재 자리가 조합이 있다면? +1
 111 => 이전놈과 현재 자리가 조합이 있다면? +1

 dp[n] 은 n자리 까지의 경우의 수.
 dp[n-1] 은 n-1 자리 까지의 경우의 수.

 dp[k] += d[k-1]
 
 if n-1 과 n의 조합 이있다면 :
    dp[k] += d[k-2]    




바로 앞만 보는게 아니라 두개를 봐야한다.
25114
25114

 */