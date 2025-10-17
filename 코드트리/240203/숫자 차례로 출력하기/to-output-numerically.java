import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        recursive1(1,n);
        System.out.println();
        recursive2(1,n);
    }

    private static void recursive1(int start ,int end) {
        if (end < start) {
            return;
        } else {
            System.out.print(start + " ");
            recursive1(++start, end);
        }
    }
    private static void recursive2(int start ,int end) {
        if (end < start) {
            return;
        } else {
            System.out.print(end + " ");
            recursive2(start, --end);
        }
    }


}