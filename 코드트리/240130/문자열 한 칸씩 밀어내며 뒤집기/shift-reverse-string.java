import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oneLine = br.readLine();
        StringTokenizer st = new StringTokenizer(oneLine);
        String str = st.nextToken();
        StringBuilder sb = new StringBuilder(str);
        int q = Integer.parseInt(st.nextToken());
        int n = str.length();
        for (int i = 0; i < q; i++) {
            int eachNum = Integer.parseInt(br.readLine());
            if (eachNum == 1) {
                sb.append(sb.substring(0, 1));
                sb.delete(0, 1);
            } else if (eachNum == 2) {
                sb.append(sb.substring(0, n-1));
                sb.delete(0, n - 1);
            } else if (eachNum == 3) {
                sb.reverse();
            }
            System.out.println(sb);
        }


    }
}