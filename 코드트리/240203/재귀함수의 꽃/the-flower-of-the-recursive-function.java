import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursive1(n,1);
    }

    private static void recursive1(int start ,int end) {
        if (end > start) return;

        System.out.print(start + " ");
        recursive1(--start, end);
        System.out.print(++start + " ");
    }
}