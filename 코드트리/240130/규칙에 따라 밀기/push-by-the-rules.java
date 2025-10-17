import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        String secondLine = br.readLine();
        StringBuilder sb = new StringBuilder(firstLine);

        int len = firstLine.length();
        int n = secondLine.length();

        for (int i = 0; i < n; i++) {
            if (secondLine.charAt(i) == 'L') {
                sb.append(sb.substring(0, 1));
                sb.delete(0, 1);
            } else if (secondLine.charAt(i) == 'R') {
                sb.append(sb.substring(0, len-1));
                sb.delete(0, len - 1);
            }
        }
        System.out.println(sb);


    }
}