import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));

    }
    private  static int f(int cur) {
        if (cur == 0 || cur == 1) return 1;
        return f(cur - 1)*cur;
    }

}