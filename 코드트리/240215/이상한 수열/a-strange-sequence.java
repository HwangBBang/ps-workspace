import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = sol(n);
        System.out.println(res);
    }

    private static int sol(int a) {
        if (a == 1) {
            return 1;
        } else if (a == 2) {
            return 2;
        } else {
            return (sol(a/3) + sol(a - 1));
        }
    }

}