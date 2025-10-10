
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/beakjun/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> que = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            que.add(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        boolean active1 = false;
        boolean active2 = false;
        while (!que.isEmpty()) {
            for (int i = 0; i < Math.min(k, que.size()); i++) {
                if (que.get(i) == 1) active1 = true;
                if (que.get(i) == 2) active2 = true;
            }

            int idx = 0;
            while (active1 || active2) {
                if (active1) {
                    if (que.get(idx) == 1) {
                        que.remove(idx);
                        idx = 0;
                        active1 = false;
                        continue;
                    }
                }
                if (active2) {
                    if (que.get(idx) == 2) {
                        que.remove(idx);
                        idx = 0;
                        active2 = false;
                        continue;
                    }
                }
                idx++;
            }

            time ++;

        }

        System.out.println(time);
    }
}


/*

당신은 서울과학고등학교 1학년으로, 기상곡이 울리자마자 기숙사 2층으로 달려나가 아침 점호 줄을 섰습니다.
하지만 당신은 늦어버렸고, 당신 앞에 이미  N명의 1학년과 2학년 학생이 서 있음을 알게 되었습니다.

당신은 이 N명이 모두 점호를 끝내기까지의 시간을 알고 싶습니다.
현재 p명이 점호 줄에 서 있을 때, 점호의 규칙은 다음과 같습니다.

줄의 가장 앞에 있는 min(K,p)명 중 1학년이 있으면
 -> 가장 앞에 있는 1학년이 점호를 하고 줄에서 빠지고,
 -> 2학년이 있으면 가장 앞에 있는 2학년이 점호를 하고 줄에서 빠집니다.
 -> 1학년과 2학년이 둘 다 있다면, 가장 앞에 있는 1학년 학생과 가장 앞에 있는 2학년 학생이 동시에 줄에서 빠집니다.

위 과정은 1학년과 2학년에 대해 동시에 일어나며, 시간 1이 걸립니다.

N명이 모두 점호를 끝내기까지 걸리는 시간을 구하는 프로그램을 작성하세요.

9 3
2 1 1 1 2 1 2 1 1

    2 1 1 1 2 1 2 1 1

(0) 2 1 1 1 2 1 2 1 1
(1) 1 1 2 1 2 1 1
(2) 1 1 2 1 1
(3) 1 1 1
(4) 1 1
(5) 1
(6)

* */