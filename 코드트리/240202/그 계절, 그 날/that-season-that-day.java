import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if (!isExist(y, m, d)) {
            System.out.println(-1);
            return;
        }

        System.out.println(whichWeather(m));

    }
    // 1  2  3  4  5  6  7  8  9  10  11  12
    // 31 28 31 30 31 30 31 31 30 31  30  31
    public static boolean isExist(int y, int m, int d) {
        boolean result = true;
        if (m > 12 || d > 31) return false;
        if (m < 8) {

            if (isLeapYear(y)){
                if (m == 2)
                    return (d > 29) ? false : true;
            }else{
                if (m == 2)
                    return (d > 28) ? false : true;
            }

            if (m%2 == 0) result = (d > 30) ? false : true;
            else result = (d > 31) ? false : true;

        } else {

            if (m%2 == 0) result = (d > 31) ? false : true;
            else result = (d > 30) ? false : true;
        }
        return result;
    }
    public static boolean isLeapYear(int y) {
        boolean result;
        if (y % 4 == 0){
            if (y % 100 == 0) {
                if (y % 400 == 0) result = true;
                else result = false;
            } else {
                result = true;
            }
        }
        else{ result = false;}
//        System.out.println("result = " + result);
        return result;
    }

    public static String whichWeather(int m) {
        String result;
        if (3<=m && m <=5) result = "Spring";
        else if (6<=m && m <=8) result = "Summer";
        else if (9<=m && m <=11) result = "Fall";
        else result = "Winter";

        return result;

    }
}