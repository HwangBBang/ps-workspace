import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ns = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s)).toArray();
        int res = 1;
        for (int n : ns) res *= n;
        System.out.println(f(res));
    }
    private static int f(int n) {
        if (n == 0) return 0;
        int cur = n % 10;
        int left = n / 10;

        return f(left) + cur;
    }
}