import java.util.Scanner;
import java.util.TreeSet;

class Tuple implements Comparable<Tuple> {
    int len, s, e;

    public Tuple(int len, int s, int e) {
        this.len = len;
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Tuple t) {
        if(this.len != t.len)
            return t.len - this.len;  // l 기준 내림차순 정렬
        else if(this.s != t.s)
            return this.s - t.s;      // s 기준 오름차순 정렬
        else
            return this.e - t.e;      // e 기준 오름차순 정렬
    }
}

public class Main {
    // 변수 선언
    public static int n, m;
    public static TreeSet<Integer> sNum = new TreeSet<>();
    public static TreeSet<Tuple> sLen = new TreeSet<>();  // (길이, 시작 숫자, 끝 숫자)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();

        // sNum : 지워진 숫자 모음(코드의 깔끔한 처리를 위해
        // 범위 밖의 숫자를 treeset에 추가했습니다)
        sNum.add(-1);
        sNum.add(n + 1);
        // sLen : (구간의 길이, 시작 숫자, 끝 숫자)
        // 길이가 긴 구간부터 나오도록 합니다.
        sLen.add(new Tuple(n + 1, -1, n + 1));

        for(int i = 0; i < m; i++) {
            // 숫자를 입력받습니다.
            int y = sc.nextInt();

            // 입력받은 숫자를 treeset에 추가합니다.
            sNum.add(y);

            // 입력받은 숫자 y를 기준으로
            // 그 바로 뒤의 숫자를 z, 바로 앞의 숫자를 x라고 두었습니다.
            int z = sNum.higher(y);
            int x = sNum.lower(y);
            
            // 구간의 길이는 (x ~ z) 구간이 사라지며,
            // (x ~ y) 구간과 (y ~ z) 구간이 새로 생겨납니다.
            sLen.remove(new Tuple(z - x - 1, x, z));
            sLen.add(new Tuple(y - x - 1, x, y));
            sLen.add(new Tuple(z - y - 1, y, z));

            // y가 추가된 후로 구간 중 가장 긴 구간을 찾아 출력합니다.
            System.out.println(sLen.first().len);
        }
    }
}
