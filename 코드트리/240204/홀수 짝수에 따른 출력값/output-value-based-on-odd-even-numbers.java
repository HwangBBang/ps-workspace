import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println(fEven(n));
        } else {
            System.out.println(fOdd(n));
        }

    }
    private  static int fEven(int cur) {
        if (cur == 2) return cur;
        return fEven(cur - 2) + cur;
    }
    private  static int fOdd(int cur) {
        if (cur == 1) return cur;
        return fOdd(cur - 2) + cur;
    }

}