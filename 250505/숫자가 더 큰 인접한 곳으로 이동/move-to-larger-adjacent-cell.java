import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
   static int n ;
    static int[][] grid;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> queue;

    static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());

        queue = new ArrayList<>();

        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < n; ii++) {
                grid[i][ii] = Integer.parseInt(st.nextToken());
            }
        }
        queue.add(grid[row - 1][col - 1]);
        move(row-1, col-1);

        printOneline(queue);

    }

    static void move(int row, int col) {
        while (true) {
            Position position = isRange(row, col);
            if (position.row == row && position.col == col) {
                break;
            }
            row = position.row;
            col = position.col;
        }
    }

    static Position isRange(int row, int col) {
        int preValue = grid[row][col];
        Position p = new Position(row, col);

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if (nextRow < 0 || nextRow >= n ||nextCol < 0 || nextCol >= n || preValue >= grid[nextRow][nextCol]) continue;

            preValue = grid[nextRow][nextCol];
            p = new Position(nextRow, nextCol);
            queue.add(preValue);
            return p;
        }
        return p;
    }

    static void printOneline(List<Integer> line){
        for (Integer elem : line) {
            System.out.print(elem + " ");
        }
//        System.out.println();
    }
}

