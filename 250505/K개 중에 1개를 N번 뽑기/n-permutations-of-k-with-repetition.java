import java.io.*;
import java.util.*;

public class Main {
    static int k, n;
    static List<Integer> queue;
    static List<List<Integer>> answer;



    //     재귀함수를 이용하면, 순열과 조합을 만들 수 있다 . ( 백 트랙킹 )
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        queue = new ArrayList<>();
        answer = new ArrayList<>();
        choice(1);

        for (List<Integer> integers : answer) {
            printOneline(integers);
        }

//      k 선택 범위
//      n 은 자리 수  => 재귀
    }

    static void choice(int num) {
        if (num > n) {
            answer.add(new ArrayList<>(queue));
            return;
        }
        for (int i = 1; i <= k; i++) {
            queue.add(i);
            choice(num + 1);
            queue.remove(queue.size() - 1);
        }
    }

    static void printOneline(List<Integer> line){
        for (Integer elem : line) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
