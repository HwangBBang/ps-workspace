import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] points = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) points[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(points);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int lowerIdx = lowerBound(points, a); // 첫 ≥ a
            int upperIdx = upperBound(points, b); // 첫 > b
            int count = upperIdx - lowerIdx;
            out.append(count).append('\n');
        }
        System.out.print(out.toString());
    }

    static int lowerBound(int[] arr, int x) { // 첫 번째 >= x
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi)/2;
            if (arr[mid] >= x) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int upperBound(int[] arr, int x) { // 첫 번째 > x
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi)/2;
            if (arr[mid] > x) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

}