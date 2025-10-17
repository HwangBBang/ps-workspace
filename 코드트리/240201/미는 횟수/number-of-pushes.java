import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ori = br.readLine();
        StringBuilder con = new StringBuilder(br.readLine());

        int cnt = 0;

        while (true){
            if (cnt > con.length()) {
                System.out.println(-1);
                break;
            }
            if (ori.equals(con.toString())) {
                System.out.println(cnt);
                break;
            }
            con = shift(con);
            cnt++;

        }


    }

    static StringBuilder shift(StringBuilder con) {
        con.append(con.substring(0, 1));
        con.delete(0,1);
        return con;
    }
}