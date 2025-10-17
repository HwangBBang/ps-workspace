import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (isPalindrome(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static Boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return (s.equals(sb.reverse().toString())) ? true : false;
    }

}