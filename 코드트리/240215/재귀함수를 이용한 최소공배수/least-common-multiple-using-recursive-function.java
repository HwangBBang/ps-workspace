import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).
                mapToInt(a -> Integer.parseInt(a)).toArray();

        int l = arr[0];
        for (int i : arr) {
            l = sol(l, i);
        }
        System.out.println(l);
    }

    private static int gcd(int a,int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    private static int sol(int a,int b) {
        return a * (b / gcd(a, b));
    }

}