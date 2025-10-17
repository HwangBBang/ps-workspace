import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        System.out.println(findSub(a,b));
    }

    public static int findSub(String str ,String subStr) {
        int len = str.length();
        int subLen = subStr.length();

        for (int i = 0; i <= len-subLen; i++) {
            if (str.substring(i, i + subLen).equals(subStr)) {
                return i;
            }
        }
        return -1;
    }

}