import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] s = new String[]{"apple", "banana", "grape", "blueberry", "orange"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        String c = br.readLine();
        for (String eachS : s) {
            if (eachS.substring(2,3).equals(c) || eachS.substring(3,4).equals(c)) {
                result++;
                System.out.println(eachS);
            }
        }

        System.out.println(result);
    }
}