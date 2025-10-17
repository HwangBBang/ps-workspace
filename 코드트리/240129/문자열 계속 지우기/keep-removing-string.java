import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oneLine = br.readLine().trim();
        String secondLine = br.readLine().trim();

        StringBuilder beRemoved = new StringBuilder(oneLine);

        int idx = 0;
        int len = secondLine.length();
        while (true) {

            int totalLen = beRemoved.length();
            // if 끝까지 탐색했다면 -> 종료
            if (idx +len > totalLen) break;

            if (beRemoved.substring(idx, idx + len).equals(secondLine)) {
                beRemoved.delete(idx, idx + len);
                idx = 0;
                continue;
            }
            idx++;
        }
        System.out.println(beRemoved);

    }
}