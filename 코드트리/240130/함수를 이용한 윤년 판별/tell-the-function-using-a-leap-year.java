import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String res = (isLeapYear(n)) ? "true" : "false";
        System.out.println(res);
    }
    static boolean isLeapYear(int a) {
        if (a % 4 == 0) {
            if (a % 100 == 0) {
                if (a % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }

}