// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for (int k = 1; k <= n; k++) {
            int min = scores[k];
            int max = scores[k];

            for (int j = k; j > 0; j--) {
                min = Math.min(min,scores[j]);
                max = Math.max(max,scores[j]);
                dp[k] = Math.max(dp[k], dp[j - 1] + diff(max, min));
            }
        }
        answer = dp[n];


//        시그마 |조의 최대 성적 - 조의 최저 성적| => Max 가 되도록
//        조는 아래 반례로르 통해 연속적 이여야함
//      dp[k] 는 k 번째 학생까지의 종합 조 성적
//      dp[k] 는 k 번째 학생까지의 종합 조 성적
//      지속적으로 알아야하는 값은 k 번 째 학생까지의 최대성적과 최소성적
        System.out.println(answer);

    }

    private static int diff(int a, int b) {
        return Math.abs(a - b);
    }
}


/*
N(1 ≤ N ≤ 1,000)명의 학생들

조별 수업

잘 하는 학생들과 덜 잘 하는 학생들을 같은 조로 묶어

실력 차이가 많이 나도록 조를 편성하는 것

같은 조에 속하게 된 학생들의 나이 차이가 많이 날 경우  X

따라서 선생님들은 우선 학생들을 나이 순서대로 정렬한 다음에, 적당히 학생들을 나누는 방식으로 조를 짜기

각각의 조가 잘 짜여진 정도
=> 그 조에 속해있는 가장 점수가 높은 학생의 점수와 가장 점수가 낮은 학생의 점수의 차이

전체적으로 조가 잘 짜여진 정도
=> 각각의 조가 잘 짜여진 정도의 합

한 명으로 조가 구성되는 경우에는 그 조의 잘 짜여진 정도가 0이 된다(가장 높은 점수와 가장 낮은 점수가 같으므로).

변인은 무엇인가?
=> 조의 크기? X
=> 조의 크기가 같을 필요 없음

"n - 1 명일 때" 와 "n 명일 때" 차이
추가된 사람이 어떤 조에 속한다고 했을 때 값을 증가 할 수 있는 것 중 최대를 선택.

1 9 -> 8
2 8 -> 6

2 9 -> 7
1 8 -> 7


2 5 7 1 3 4 8 6 9 3

  [1, 2, 3, 3, 4, 5, 6, 7, 8, 9]
  19 28 37 36 45 -> 8 6 4 3 1 X


  [2, 2, 2, 1, 1, 1, 1, 1, 1, 1]
  [2, 5, 7, 7, 7, 7, 8, 8, 9, 9]

  [2, 5, 7, 1, 3, 4, 8, 6, 9, 3]
   0
     3
       5

        조에 병합
        조에 병합
       dp[k] = dp[k-1] + max (차이(s[k],maxS[k]), 차이(s[k],minS[k]))

        추가 조가 이득인 경우
       dp[k] = dp[k-2] + 차이(s[k],s[k-1])


   위 풀이는 조가 어디서 끊겼는지를 알 수 없기에 정답이 아님
   그럼 조가 어디서 끊겼는지 알아야함

   언제 끊느냐 ,위와 마찬가지로 이득일 때
   걍 다 돌아봐야함 
   
 */