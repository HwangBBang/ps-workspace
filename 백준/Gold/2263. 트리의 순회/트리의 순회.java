
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] inOrder;
    static int[] inOrderIdx;
    static int[] postOrder;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n+1];
        inOrderIdx = new int[n+1];
        postOrder = new int[n+1];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIdx[inOrder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) postOrder[i] = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        solution(1, n, 1, n);
        System.out.println(sb);
    }

    private static void solution(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight) return;

        int rootValue = postOrder[postRight];
        int rootIdx = inOrderIdx[rootValue];
        int leftSubTreeSize = rootIdx - inLeft;
        sb.append(rootValue).append(" ");

        // 왼쪽 서브 트리
        solution(inLeft, rootIdx - 1, postLeft, postLeft + leftSubTreeSize - 1);

        // 오른쪽 서브 트리
        solution(rootIdx + 1, inRight, postLeft + leftSubTreeSize, postRight - 1);

    }
}


/*

n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다.

이와 같은 이진 트리의 인오더와 포스트오더가 주어졌을 때, 프리오더를 구하는 프로그램을 작성하시오.

in-order -> pre-order

pre | R A B
in  | A R B
post| A B R

루트를 찾자..
post-order의 마지막은 항상 루트
inorder 에서 루트를 알면 좌우로 쉽게 나눌 수 있음
inorder 위치를 기록할 녀석을 추가로 저장
또한, inorder 각 루트의 위치 기준
    왼쪽의 크기는 = 왼쪽 서브트리의 크기
    오른쪽의 크기는 = 오른쪽 서브트리의 크기

스택 ? 재귀 ?
1. 재귀 먼저


*/