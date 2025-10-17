import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder res = new StringBuilder();
        res.append(s);
        res.append("Hello");
//        System.out.println(res.getClass());
//        System.out.println(res.toString().getClass());
//        System.out.println(res.toString()); sout 이 자동으로 String 으로 캐스팅 
        System.out.println(res);
    }
}