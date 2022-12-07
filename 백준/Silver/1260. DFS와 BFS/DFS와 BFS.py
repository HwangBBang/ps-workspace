from collections import deque
import sys
input = sys.stdin.readline

n,m,v = map(int,input().split())
# 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1, 000) / vertex : n개
# 간선의 개수 M(1 ≤ M ≤ 10, 000) / edge : m 개
# 탐색을 시작할 정점의 번호 V가 주어진다 / start_vertex : v


# 인접 연결리스트로 에지와 버택스 구현
# vertexList = [[0 for i in range(0, n+1)]for i in range(0, n+1)]
visited = [False for _ in range(n+1)]
edgeList = [[0 for i in range(0, n+1)]for i in range(0, n+1)]


DFS_Result = []
BFS_Result = []

for i in range(m):
    # edgeList[i] = list(map(int, input().split()))
    v1, v2 = map(int, input().split())
    edgeList[v1][v2] = 1
    edgeList[v2][v1] = 1
# DFS 함수 정의
def DFS(v):
    # 방문 했다면
    if visited[v] == True:
        return
    
    # 방문 하지 않았다면
    if visited[v] == False:
        
        # 방문했음
        visited[v] = True
        # 결과리스트에 추가
        DFS_Result.append(v)
        # 버택스 v와 연결된(에지로) 다른 버택스를 탐색함 (그 중에 작은 걸로)
        for k in range(1,n+1):
            # 에지로 연결되어 있다면
            if edgeList[v][k] == 1: 
                DFS(k)
    return

# BFS 함수 정의
def BFS(v):
    # 큐 생성
    que = deque([v])
    # 방문했음
    visited[v] = True
    # 결과리스트에 추가
    BFS_Result.append(v)
    
    # 큐가 empty가 될 때 까지
    while que:
        popV = que.popleft()
        
        for i in range(1,n+1):
            if visited[i] == False and edgeList[popV][i] == 1:
                que.append(i)
                BFS_Result.append(i)
                visited[i] = True
        
        
    return

# 시작 노드(vertex)인 v 부터 DFS 탐색 
DFS(v)

# DFS 한번 돌았으니까 다시 방문안했던걸로 초기화
visited = [False for _ in range(n+1)]

# 시작 노드(vertex)인 v 부터 DFS 탐색
BFS(v)


# 결과 출력
for i in range(len(DFS_Result)):
    print(DFS_Result[i],end=" ")
print()
for i in range(len(BFS_Result)):
    print(BFS_Result[i],end=" ")