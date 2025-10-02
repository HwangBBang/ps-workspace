import java.util.Scanner;

public class Main {
    static class Result {
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;

        public Result(int aCnt, int bCnt, int cCnt){
            this.aCnt = aCnt;
            this.bCnt = bCnt;
            this.cCnt = cCnt;
        }
        @Override
        public String toString(){
            return aCnt + " " + bCnt + " " + cCnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // rows
        int m = sc.nextInt();  // cols
        int k = sc.nextInt();  // queries

        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = sc.next(); // 각 행의 문자열(길이 m)
        }

        // 질의 입력(이미 배열로 받아두는 형태를 유지)
        int[] r1 = new int[k];
        int[] c1 = new int[k];
        int[] r2 = new int[k];
        int[] c2 = new int[k];
        for (int i = 0; i < k; i++) {
            r1[i] = sc.nextInt();
            c1[i] = sc.nextInt();
            r2[i] = sc.nextInt();
            c2[i] = sc.nextInt();
        }

        // 문자별 2D prefix sum (1-based 인덱싱)
        int[][] pa = new int[n + 1][m + 1]; // 'a' 누적합
        int[][] pb = new int[n + 1][m + 1]; // 'b' 누적합
        int[][] pc = new int[n + 1][m + 1]; // 'c' 누적합

        for (int i = 1; i <= n; i++) {
            String row = lines[i - 1];
            for (int j = 1; j <= m; j++) {
                char ch = row.charAt(j - 1);
                int addA = (ch == 'a') ? 1 : 0;
                int addB = (ch == 'b') ? 1 : 0;
                int addC = (ch == 'c') ? 1 : 0;

                pa[i][j] = pa[i - 1][j] + pa[i][j - 1] - pa[i - 1][j - 1] + addA;
                pb[i][j] = pb[i - 1][j] + pb[i][j - 1] - pb[i - 1][j - 1] + addB;
                pc[i][j] = pc[i - 1][j] + pc[i][j - 1] - pc[i - 1][j - 1] + addC;
            }
        }

        // 질의 처리
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < k; i++) {
            Result res = getResult(pa, pb, pc, r1[i], c1[i], r2[i], c2[i]);
            out.append(res).append('\n');
        }
        System.out.print(out.toString());
    }

    private static Result getResult(int[][] pa, int[][] pb, int[][] pc,
                                    int r1, int c1, int r2, int c2) {
        int a = rectSum(pa, r1, c1, r2, c2);
        int b = rectSum(pb, r1, c1, r2, c2);
        int c = rectSum(pc, r1, c1, r2, c2);
        return new Result(a, b, c);
    }

    // 누적합에서 직사각형 합 추출
    private static int rectSum(int[][] p, int r1, int c1, int r2, int c2) {
        return p[r2][c2] - p[r1 - 1][c2] - p[r2][c1 - 1] + p[r1 - 1][c1 - 1];
    }
}

/*
N X M 크기의 2차원 격자가 알파벳 소문자 a, b, c 로만 이루어져 있습니다.
K 개의 질의에 대해 주어진 직사각형 범위 안에 각각 a, b, c 가 몇 개씩 있는지를 구하는 프로그램을 작성해보세요.
1-base 로,,
 x x x
 x x x
 x x x

(r2, c2) - (r1-1, c2) - (r2, c1-1) + (r1-1, c1-1)
*/