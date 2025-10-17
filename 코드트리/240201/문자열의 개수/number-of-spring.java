import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> res = new ArrayList<>();
        int cnt = 0;
        
        while (true){
            String s = br.readLine();
            if (s.equals("0"))break;
            cnt++;
            
            if (cnt % 2 == 1) res.add(s);
        }
        System.out.println(cnt);
        for (String re : res) {
            System.out.println(re);
        }

    }
}