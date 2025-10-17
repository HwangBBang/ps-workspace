import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < m; i++) {
            StringTokenizer si = new StringTokenizer(br.readLine());
            int ni = Integer.parseInt(si.nextToken());
            int mi = Integer.parseInt(si.nextToken());
            System.out.println(subSum(ni, mi));

        }

    }

    public static int subSum(int a, int b) {
        int res = 0;
        for (int i = a-1; i <=b-1 ; i++) {
            res += A[i];
        }
        return res;
    }


}