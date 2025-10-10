
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        x[n] = x[0];
        y[n] = y[0];

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += x[i] * y[i + 1] - x[i + 1] * y[i];
        }
        double answer = Math.abs(sum) / 2.0;

        System.out.printf("%.1f", answer);

    }

}

// 신발끈
/*
  삼각
  (1 ,1) (1, 4) (8, 1)
   8 1 1 8
   1 1 4 1
  (81 + 14 + 11 ) - (11 + 11 + 84)
  = (8+4+1) - (1+1+32)
  = -21 => 21
  = 21 / 2

  사각
  (1 ,1) (1, 4) (8, 4) (8, 1)
   1 1 8 8 1
   1 4 4 1 1
  (14 + 14 + 81 + 81) - (11 + 84 + 84 + 11)
  = (4+4+8+8) - (1+32+32+1)
  = -42 = 42
  = 42 / 2

  육각
  (0, r3) (1, 0) (3, 0) (4, r3) (3, 2r3) (1, 2r3)
  0   1  3  4    3   1  0
  r3  0  0 r3  2r3 2r3 r3
  (00 + 10 + 3r3 + 8r3 + 6r3 + r3) - (1r3 + 30 + 40, 3r3 + 2r3 + 0r3)
  (18r3) - (6r3)
  = 12r3
  = 6r3



* */