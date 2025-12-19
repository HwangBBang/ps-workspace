// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수열의 길이
        int k = Integer.parseInt(st.nextToken()); // 삭제 횟수

        int[] s = new int[n + 1];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        int oddCnt = 0;
        int evenCnt = 0;

        for (int end = 1; end <= n; end++) {
            if (s[end] % 2 != 0) oddCnt++;
            else evenCnt++;

            while (oddCnt > k) {
                if (s[start] % 2 == 0) {
                    evenCnt--;
                } else {
                    oddCnt--;
                }
                start++;
            }

            answer = Math.max(evenCnt, answer);
        }

        System.out.println(answer);

    }
}
/*
    짝수로만 일어진 부부분 수열 중 가장 긴것의 길이를 찾아야해

    길이가 n 인 녀석에대해서,

     n = 1_000_000

     O(n ^ 2) 는 시간 초과

     그럼 스택을 써야할까?
     투 포인터?

     우선 앞에서 부터 봐야겠지?
     길이 만 봐야하니까, 굳이 적재 ㄴㄴ

     투 포인터 -> TLE -> 현재 최악의 케이스에서 O(n^2)

     메모제이션을 추가해야할까?
      우선 투포인터 알고리즘의 핵심
      - start마다 end가 다시 처음부터 확장 X
      - 포인터 재사용 해야함
      -> start + end 이동 합쳐서 n 번만 이동하도록

     end 를 늘릴때
     - 짝수 : result ++
     - 홀수 : skipCnt ++

     skipCnt > k 라면,
     s[start] 값이 짝 이라면 result --
     s[start] 값이 홀 이라면 skipCnt --
     start 한칸 이동

*/