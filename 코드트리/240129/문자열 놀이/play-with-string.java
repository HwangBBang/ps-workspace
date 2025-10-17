import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oneLine = br.readLine();
        StringTokenizer st = new StringTokenizer(oneLine);

        String s = st.nextToken();
        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < q; i++) {
            String eachLine = br.readLine();
            StringTokenizer stEach = new StringTokenizer(eachLine);

            int elem1 = Integer.parseInt(stEach.nextToken());
            if (elem1 == 1) {
                int elem2 = Integer.parseInt(stEach.nextToken()) -1 ;
                int elem3 = Integer.parseInt(stEach.nextToken()) -1 ;

                s = swap(s, elem2, elem3);

            } else if (elem1 == 2) {
                String elem2 = stEach.nextToken();
                String elem3 = stEach.nextToken();

                s = s.replaceAll(elem2, elem3);
            }
            System.out.println(s);
        }
    }
    private static String swap(String s, int a, int b) {
        StringBuilder sb = new StringBuilder(s);
        String first = s.substring(a , a+1);
        String second = s.substring(b , b+1);
        sb.replace(a, a + 1, second);
        sb.replace(b, b + 1, first);

        return sb.toString();
    }
}