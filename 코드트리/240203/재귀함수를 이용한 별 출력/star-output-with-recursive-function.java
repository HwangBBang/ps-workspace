import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursive1(1,n);
    }

    private static void recursive1(int start ,int end) {
        if (end < start) return;
        
        for (int i = 0; i < start ; i++) {
            System.out.print("*");
        }
        System.out.println();
        recursive1(++start, end);
    }
}