import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oneLine = br.readLine().trim();
        StringBuilder st = new StringBuilder(oneLine);
        st.delete(1, 2);
        st.delete(oneLine.length()-3, oneLine.length()-2);

        System.out.println(st);

        }
}