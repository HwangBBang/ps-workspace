// package baekjoon.gold;

import java.io.*;
import java.util.*;


public class Main {
    static int n;

    static class UnionFind {
        Map<String, String> parent; // key 의 엄마는 value 다.
        Map<String, Integer> size;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.size = new HashMap<>();
        }

        public void add(String friend) {
            parent.put(friend, friend);
            size.put(friend, 1);
        }

        public void union(String f1, String f2) {
            String rf1 = find(f1), rf2 = find(f2);
            if (rf1.equals(rf2)) return;
            if (size.get(rf1) < size.get(rf2)) {
                String tmp = rf1;
                rf1 = rf2;
                rf2 = tmp;
            }
            parent.put(rf2, parent.get(rf1)); // f2 의 엄마를 f1 쪽으로
            size.put(rf1, size.get(rf1) + size.get(rf2));
        }

        public String find(String friend) {
            while (!friend.equals(parent.get(friend))) {
                String tmpParent = parent.get(friend);
                parent.put(tmpParent, parent.get(tmpParent));
                friend = tmpParent;
            }
            return parent.get(friend);
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            UnionFind uf = new UnionFind();
            String[] lines = new String[n];
            for (int i = 0; i < n; i++) {
                lines[i] = br.readLine();
                st = new StringTokenizer(lines[i]);
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                uf.add(f1);uf.add(f2);
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(lines[i]);
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                uf.union(f1,f2);
                sb.append(uf.size.get(uf.find(f1))).append("\n");
            }
        }

        System.out.println(sb);
    }

}
