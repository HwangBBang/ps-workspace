import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


        String res = (isExist(m, d) ? "Yes" : "No");
        System.out.println(res);

    }
    // 1  2  3  4  5  6  7  8  9  10  11  12
    // 31 28 31 30 31 30 31 31 30 31  30  31
    public static boolean isExist(int m, int d) {
        boolean result = true;
        if (m > 12 || d > 31) return false;
        if (m < 8) {
            if (m == 2) return (d > 28) ? false : true;
            if (m%2 == 0) result = (d > 30) ? false : true;
            else result = (d > 31) ? false : true;
        } else {
            if (m%2 == 0) result = (d > 31) ? false : true;
            else result = (d > 30) ? false : true;
        }
        return result;
    }
}