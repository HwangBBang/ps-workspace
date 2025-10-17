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
            return 2;
        } else if (a == 2) {
            return 4;
        } else {
            return (sol(a - 1) * sol(a - 2))%100;
        }
    }

}

// 2 4 8 32