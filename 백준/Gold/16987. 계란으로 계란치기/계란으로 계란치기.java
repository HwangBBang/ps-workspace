// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    static Egg[] eggs;
    static int answer = 0;

    static int n;
    static class Egg {
        int armor;
        int weight;

        public Egg(int armor, int weight) {
            this.armor = armor;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int armor = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(armor, weight);
        }
        backtracking(0);
        System.out.println(answer);
    }

    static void backtracking(int cur) {
        if (cur == n ) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i].armor <= 0) cnt ++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        if (eggs[cur].armor <= 0) {
            backtracking(cur + 1);
            return;
        }

        boolean canHit = false;

        for (int other = 0; other < n; other++) {
            if (cur == other) continue;
            if (eggs[other].armor <= 0) continue;

            canHit = true;
            int prevCur = eggs[cur].armor;
            int prevOther = eggs[other].armor;

            eggs[cur].armor -= eggs[other].weight;
            eggs[other].armor -= eggs[cur].weight;

            backtracking(cur + 1);

            eggs[cur].armor = prevCur;
            eggs[other].armor = prevOther;

        }
        if (!canHit) {
            backtracking(cur + 1);
        }

    }


}

/*
    문제를 소개하기 전,
    계란으로 계란을 치게 될 경우 어떤 일이 벌어지는지를 먼저 이해하고 가자.

    각 계란에는 내구도와 무게가 정해져있다.

    계란으로 계란을 치게 되면 각 계란의 내구도는 상대 계란의 무게만큼 깎이게 된다.

    그리고 내구도가 0 이하가 되는 순간 계란은 깨지게 된다.

    예를 들어,
    계란 1의 내구도가 7, 무게가 5이고
    계란 2의 내구도가 3, 무게가 4라고 해보자.
    계란 1으로 계란 2를 치게 되면,

    계란 1의 내구도는 4만큼 감소해 3이 되고 계란 2의 내구도는 5만큼 감소해 -2가 된다.

    충돌 결과 계란 1은 아직 깨지지 않았고 계란 2는 깨졌다.

    유현이가 인범이에게 알려준 퍼즐은 일렬로 놓여있는
    계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨는 문제였다.
    구체적으로 계란을 치는 과정을 설명하면 아래와 같다.

*/