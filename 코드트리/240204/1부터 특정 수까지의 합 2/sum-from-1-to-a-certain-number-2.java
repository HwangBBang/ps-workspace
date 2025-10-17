import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(rec(n));
        
    }
    private  static int rec(int cur) {
        if (cur == 1) return 1;
        return rec(cur - 1) + cur;
    }

}