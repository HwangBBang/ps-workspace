import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String res = (isOver(br.readLine())) ? "Yes" : "No";
        System.out.println(res);
    }

    public static boolean isOver(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (!s.substring(i-1,i).equals(s.substring(i,i+1))) {
                return true;
            }
        }

        return false;
    }
}