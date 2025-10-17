import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int cnt = 0;

        String[] arrS = new String[n];

        for (int i = 0; i < n; i++) {
            arrS[i] = br.readLine();
            sum += arrS[i].length();
            cnt += arrS[i].indexOf("a") == 0 ? 1 : 0;
        }
        System.out.println(sum+" "+cnt);


    }
}