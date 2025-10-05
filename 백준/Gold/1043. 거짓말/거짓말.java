
import java.io.*;
import java.util.*;

public class Main {
    static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n + 1];
            size   = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int findRoot(int x) {
            if (parent[x] == x) return x;
            return parent[x] = findRoot(parent[x]);
        }

        void union(int a, int b) {
            int ra = findRoot(a), rb = findRoot(b);
            if (ra == rb) return ;

            // union by size
            if (size[ra] < size[rb]) {
                int tmp = ra;
                ra = rb;
                rb = tmp;
            }

            parent[rb] = ra;
            size[ra] += size[rb];
            size[rb] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/beakjun/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthSize = Integer.parseInt(st.nextToken());
        int[] truth = new int[truthSize];
        for (int i = 0; i < truthSize; i++)
            truth[i] = Integer.parseInt(st.nextToken());

        UnionFind uf = new UnionFind(n);

        List<int[]> parties = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int[] party = new int[cnt];

            for (int j = 0; j < cnt; j++)
                party[j] = Integer.parseInt(st.nextToken());

            parties.add(party);

            // 같은 파티 참석자들을 하나의 컴포넌트로 묶기
            for (int j = 1; j < cnt; j++)
                uf.union(party[0], party[j]);
        }

        // 진실을 아는 사람이 없으면 모든 파티에서 과장 가능
        if (truthSize == 0) {
            System.out.println(m);
            return;
        }


        boolean[] result = new boolean[n + 1];
        for (int t : truth) result[uf.findRoot(t)] = true;

        int answer = 0;
        for (int[] party : parties) {
            boolean contains = false;
            for (int p : party) {
                if (result[uf.findRoot(p)]) contains = true;
            }

            if (!contains) answer++;
        }
        System.out.println(answer);
    }
}

/*


[문제]
지민이는 파티에 가서 이야기 하는 것을 좋아한다.
파티에 갈 때마다, 지민이는 지민이가 가장 좋아하는 이야기를 한다.
지민이는 그 이야기를 말할 때, 있는 그대로 진실로 말하거나 엄청나게 과장해서 말한다.
당연히 과장해서 이야기하는 것이 훨씬 더 재미있기 때문에, 되도록이면 과장해서 이야기하려고 한다.
하지만, 지민이는 거짓말쟁이로 알려지기는 싫어한다.

문제는 몇몇 사람들은 그 이야기의 진실을 안다는 것이다.
따라서 이런 사람들이 파티에 왔을 때는, 지민이는 진실을 이야기할 수 밖에 없다.

당연히, 어떤 사람이 어떤 파티에서는 진실을 듣고,
또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다.

지민이는 이런 일을 모두 피해야 한다.

사람의 수 n이 주어진다.
그리고 그 이야기의 진실을 아는 사람이 주어진다.
그리고 각 파티에 오는 사람들의 번호가 주어진다.

지민이는 모든 파티에 참가해야 한다.
이때, 지민이가 거짓말쟁이로 알려지지 않으면서,
과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 사람의 수 N과 파티의 수 M이 주어진다.

둘째 줄에는 이야기의 진실을 아는 사람의 수와 번호가 주어진다.
진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들의 번호가 주어진다.
사람들의 번호는 1부터 N까지의 수로 주어진다.

셋째 줄부터 M개의 줄에는 각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어진다.
N, M은 50 이하의 자연수이고, 진실을 아는 사람의 수는 0 이상 50 이하의 정수, 각 파티마다 오는 사람의 수는 1 이상 50 이하의 정수이다.

4 3
0
2 1 2
1 3
3 2 3 4

=> 3

4 1
1 1
4 1 2 3 4

=> 0

4 5
1 1
1 1
1 2
1 3
1 4
2 4 1

=> 2

10 9
4 1 2 3 4
2 1 5
2 2 6
1 7
1 8
2 7 8
1 9
1 10
2 3 10
1 4

m개의 그래프가 주어진다.
알려진 번호 노드가 포함된 그래프는 제거.
알려진 번호 노드가 포함되지않은 그래프만 카운트.
*/
