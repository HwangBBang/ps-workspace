from collections import deque


def solution(places):
    answer = []
    for place in places:
        if isKeepDis(place):
            answer.append(1)
        else:
            answer.append(0)
    print(answer)
    return answer


def isKeepDis(place):
    for i, line in enumerate(place):
        for j, node in enumerate(line):
            if node == 'P':
                if not bfs(place, i, j):
                    # 문제가있다면
                    return False
    return True


dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]


def bfs(graph, row, col):
    visited = [[False]*5 for _ in range(5)]
    que = deque([(row, col, 0)])
    visited[row][col] = True

    while que:
        ni, nj, nd = que.popleft()
        if nd > 2:
            continue
        if nd != 0 and graph[ni][nj] == 'P':
            return False

        for r, c in zip(dr, dc):
            di, dj = ni+r, nj+c

            if di < 0 or dj < 0 or di > 4 or dj > 4:
                continue
            if visited[di][dj] or graph[di][dj] == 'X':
                continue

            que.append((di, dj, nd+1))
            visited[di][dj] = True

    return True