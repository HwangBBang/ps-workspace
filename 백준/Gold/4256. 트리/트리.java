
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] preorder;
    static int[] inorder;
    static int[] inorderIdx;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            preorder = new int[n + 1];
            inorder = new int[n + 1];
            inorderIdx = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
                inorderIdx[inorder[i]] = i;
            }
            sb = new StringBuilder();
            solution(1, n, 1, n);
            System.out.println(sb);

        }
    }

    private static void solution(int inLeft, int inRight, int preLeft, int preRight) {
        if (preLeft > preRight || inLeft > inRight) return;

        int rootValue = preorder[preLeft];
        int rootIdx = inorderIdx[rootValue];
        int leftSubTreeSize = rootIdx - inLeft;

        // pre : root ( ) ( )
        // left
        int leftSubTreeLeft = preLeft + 1;
        int leftSubTreeRight = preLeft + leftSubTreeSize;
        solution(inLeft, rootIdx - 1, leftSubTreeLeft, leftSubTreeRight);

        // right
        int rightSubTreeLeft = preLeft + leftSubTreeSize + 1;
        int rightSubTreeRight = preRight;
        solution(rootIdx + 1, inRight, rightSubTreeLeft, rightSubTreeRight);

        sb.append(rootValue).append(" ");

    }

}

/*
    pre , in -> post 구하기

*/