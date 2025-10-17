import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(rec(n));

    }
    private  static int rec(int cur) {
        if (cur == 0) return 0;
        return rec(cur/10) + (cur%10)*(cur%10);
    }
    //6543
}