import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i%2==1) {
                res.append(s.substring(i,i+1));
            }
        }
        res.reverse();

        System.out.println(res.toString());
    }
}