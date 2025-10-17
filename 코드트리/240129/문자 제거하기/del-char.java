import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oneLine = br.readLine().trim();
        StringBuilder st = new StringBuilder(oneLine);

        while(true){
            int len = st.length();
            if (len == 1) break;
            int i = Integer.parseInt(br.readLine());
            if (i >= len) {
                st.delete(len - 1, len);
            } else {
                st.delete(i, i+1);
            }
            System.out.println(st);
        }





        }
}