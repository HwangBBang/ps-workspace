import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursive2(1,n);
        recursive1(1,n);


    }

    private static void recursive1(int start ,int end) {
        if (start > end) return;

        for (int i = 0; i < start; i++) {
            System.out.print("* ");
        }System.out.println();

        recursive1(++start, end);

    }
    private static void recursive2(int start ,int end) {
        if (start > end) return;

        for (int i = 0; i < end; i++) {
            System.out.print("* ");
        }System.out.println();

        recursive2(start, --end);

    }
}