
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/beakjun/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int removeCnt = (int) Math.round(n * 0.15);

        int[] levels = new int[n];

        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(levels);
        int sum = 0;

        for (int i = removeCnt; i < n - removeCnt; i++) {
            sum += levels[i];
        }
        int answer = (int) Math.round((double) sum / (n - removeCnt * 2));

        System.out.println(answer);

    }
}

/*


의견이 하나 이상 있다면, 문제의 난이도는 모든 사람의 난이도 의견의 30% 절사평균으로 결정한다.

절사평균이란 극단적인 값들이 평균을 왜곡하는 것을 막기 위해

가장 큰 값들과 가장 작은 값들을 제외하고 평균을 내는 것을 말한다.

30% 절사평균의 경우 위에서 15%, 아래에서 15%를 각각 제외하고 평균을 계산한다.

따라서 20명이 투표했다면, 가장 높은 난이도에 투표한 3명과 가장 낮은 난이도에 투표한 3명의 투표는 평균 계산에 반영하지 않는다는 것이다.

제외되는 사람의 수는 위, 아래에서 각각 반올림한다.

25명이 투표한 경우 위, 아래에서 각각 3.75명을 제외해야 하는데, 이 경우 반올림해 4명씩을 제외한다.

마지막으로, 계산된 평균도 정수로 반올림된다. 절사평균이 16.7이었다면 최종 난이도는 17이 된다.


* */