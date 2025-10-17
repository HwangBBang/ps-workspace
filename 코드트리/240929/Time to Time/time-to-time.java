import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int startHour = Integer.parseInt(st.nextToken());
        int startMin = Integer.parseInt(st.nextToken());
        int endHour = Integer.parseInt(st.nextToken());
        int endMin = Integer.parseInt(st.nextToken());

        int deltaMin = ((endHour - startHour) * 60) + (endMin - startMin);
        System.out.println(deltaMin);

    }
}