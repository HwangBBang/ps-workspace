import sys
input = sys.stdin.readline

n = int(input())
m = int(input())


# 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1, 000) / vertex : n개
# 간선의 개수 M(1 ≤ M ≤ 10, 000) / edge : m 개


# vertexList = [[0 for i in range(0, n+1)]for i in range(0, n+1)]

visited = [False for _ in range(n+1)]
edgeList = [[0 for i in range(0, n+1)]for i in range(0, n+1)]


DFS_Result = []

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



#1 부터 DFS 탐색
DFS(1)

# 결과 출력 / 1을 제외한 값이기 때문에 -1 
print(len(DFS_Result)-1)
