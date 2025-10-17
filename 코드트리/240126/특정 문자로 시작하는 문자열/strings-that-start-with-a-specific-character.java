import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] sArr = new String[n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sArr[i] = br.readLine();
        }

        String con = br.readLine();
        double addAll = 0.0;
        for (int i = 0; i < n; i++) {
            if (con.equals(sArr[i].substring(0, 1))) {
                res.add(sArr[i].length());
                addAll += sArr[i].length();
            }
        }
        System.out.println(res.size()+ " "+ String.format("%.2f",addAll/res.size()));



    }

}