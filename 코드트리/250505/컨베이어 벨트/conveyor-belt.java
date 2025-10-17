import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        static int n,t = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int[][] grid = new int[2][n];

        for (int i = 0; i < grid.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int ii = 0; ii < grid[0].length; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < t; i ++){
            int poped0 = shiftRight(grid[0]);
            int poped1 = shiftRight(grid[1]);
            grid[0][0] = poped1;
            grid[1][0] = poped0;
        }

        printOnline(grid[0]);
        printOnline(grid[1]);
    }

    static int shiftRight(int[] line) {
        int length = line.length;
        int temp = line[length-1];
        for (int i = length-1; i > 0; i--) {
            line[i] = line[i - 1];
        }

        return temp;
    }

    static void printOnline(int[] line){
        for (int i : line) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}
/*
* 1 2 3
* 6 5 1

* "1" 1 2 "3"
* "3" 6 5 "1"
* */
