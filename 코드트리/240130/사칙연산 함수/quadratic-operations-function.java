import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String op = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        String res;

        switch (op) {
            case "+" :
                res = a + " + " + b + " = " + add(a, b);break;
            case "-" :
                res = a + " - " + b + " = " + sub(a, b);break;
            case "*" :
                res = a + " * " + b + " = " + mul(a, b);break;
            case "/" :
                res = a + " / " + b + " = " + div(a, b);break;
            default:
                res = "False";break;
        }
        System.out.println(res);

    }

    static int add(int a, int b) {
        return a + b;
    }
    static int sub(int a, int b) {
        return a - b;
    }
    static int mul(int a, int b) {
        return a * b;
    }
    static int div(int a, int b) {
        return a / b;
    }
}