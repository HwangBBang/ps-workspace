// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int n, k;

    static class Node implements Comparable<Node> {
        int weight, price;

        public Node(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(m, v);
        }

        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nodes);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b, a)
        );

        // 작은 가방부터 & 작은 무게 부터 
        int idx = 0;
        long answer = 0;

        for (int i = 0; i < k; i++) {
            int cap = bags[i];
            while (idx < n && nodes[idx].weight <= cap) {
                pq.add(nodes[idx].price);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }

}

/*
    가방에는 최대 한 개의 보석만 넣을 수 있다.

    3 3

    2 9
    4 4
    2 5

    13, 6, 2

    가격 기준 내림차순 우선순위 큐

    작은 가방 부터 순회하면서 가방에 들어갈 수 있는 후보들을 가격 우선순위큐에 넣는다.
    들어간 후보군들은 pq 내에서 제일 비싼걸로 채택된다.
    pq를 유지한채 다음으로 큰놈

    작은 가방 부터 순회하면서 가방에 들어갈 수 있는 후보들을 가격 우선순위큐에 넣는다.
    들어간 후보군들은 pq 내에서 제일 비싼걸로 채택된다.

	작은 가방에 들어갈 수 있는 보석들은 큰 가방에도 항상 들어갈 수 있음

	큰 가방에만 들어갈 수 있는 보석들은 작은 가방에서는 애초에 후보가 아니다.

*/
