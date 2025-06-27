import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String siteName = st.nextToken();
            String sitePassword = st.nextToken();

            map.put(siteName, sitePassword);
        }

        for (int i = 0; i < m; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        
        System.out.print(sb);
    }
}
