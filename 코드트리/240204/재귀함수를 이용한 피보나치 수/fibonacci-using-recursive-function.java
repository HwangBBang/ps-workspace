import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));

    }
    private  static int f(int cur) {
        if (cur == 1 || cur == 2) return 1;
        return f(cur - 1) + f(cur - 2);
    }

}

// 1, 1, 2, 3, 5, 8 ..
//f(1) = 1
//f(2) = 1
//f(3) = f(2) +f(1)