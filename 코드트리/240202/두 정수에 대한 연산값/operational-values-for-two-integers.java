import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a > b) {
            a = logic1(a);
            b = logic2(b);
        } else {
            b = logic1(b);
            a = logic2(a);
        }
        System.out.println(a + " " + b);
        
    }

    public static int logic1(int a) {
        return (a + 25);
    }
    public static int logic2(int a) {
        return (a * 2);
    }

}