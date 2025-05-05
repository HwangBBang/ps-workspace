import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int n,k;
    static List<Integer> queue;
    static List<List<Integer>> answers;

    //     재귀함수를 이용하면, 순열과 조합을 만들 수 있다 . ( 백 트랙킹 )
    // 후보 : queue 에 담겨 있음 (자리수)
    // 범위 :
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        queue = new ArrayList<>();
        answers = new ArrayList<>();

        choice(1);
        for (List<Integer> answer : answers) {
            printOneline(answer);
        }
    }

    static void choice(int num) {
        if (num > n) {
            answers.add(new ArrayList<>(queue));
            return;
        }
        for (int i = 1; i <= k; i++) {
            if (isValid(i)) {
                queue.add(i);
                choice(num + 1);
                queue.remove(queue.size() - 1);
            }

        }
    }


    static void printOneline(List<Integer> line){
        for (Integer elem : line) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    static boolean isValid(int i) {
        int len = queue.size();

        if (len < 2) {
            return true;
        }

        for (int j = 0; j < 2; j++) {
            if (queue.get(len - j - 1) != i) {
                return true;
            }
        }
        return false;
    }


}
