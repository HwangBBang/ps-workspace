import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int res = 0;
        while (true) {
            if(m == 0)break;

            res += A[m-1];
            
            if (m % 2 == 1) {
                m -= 1;
            } else {
                m /= 2;
            }
        }
        System.out.println(res);
    }

}