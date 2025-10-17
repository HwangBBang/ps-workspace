import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static List<Integer> queue;

    //     재귀함수를 이용하면, 순열과 조합을 만들 수 있다 . ( 백 트랙킹 )
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        queue = new ArrayList<>();
        answer = 0;

        choice(1);
        System.out.println(answer);
    }

    static void choice(int num) {
        if (num > n) {
            if (isBeautiful()) {
//                printOneline(queue);
                answer++;
            }
            return;
        }
        for (int i = 1; i <= 4; i++) {
            queue.add(i);
            choice(num + 1);
            queue.remove(queue.size() - 1);
        }
    }

    static boolean isBeautiful(){
        for (int i = 0; i < n; i += queue.get(i)) {
            if (i + queue.get(i) -1 >= n) {
                return false;
            }
            for (int ii = i; ii < i + queue.get(i); ii++) {
                if (queue.get(i) != queue.get(ii)) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printOneline(List<Integer> line){
        for (Integer elem : line) {
            System.out.print(elem);
        }
        System.out.println();
    }

}


//  아름다운 수란?
//  숫자 만큼 반복이 포함된 수를 의미한다.
//  자리 수를 입력받고 아름다운 수의 갯수를 출력한다.
//   1의 자리라면 1
//   2의 자리라면 12 , 13 , 14 , 21 , 22, 31 , 41
//   3의 자리라면 111, 112, 113, 114, 121, 122, 123, 124