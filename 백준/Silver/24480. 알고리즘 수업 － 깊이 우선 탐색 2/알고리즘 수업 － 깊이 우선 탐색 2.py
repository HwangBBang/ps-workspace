
# DFS 깊이 우선 탐색 
# 그래프 : 무방향 ,모든 에지 가중치 1
# 재귀 DFS 

import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline
n,m,start = map(int, input().split())
# 인접 리스트로 에지를 관리 ,,, (행렬이 더 익숙한데 메모리초과남)
EdgeList = [[] for _ in range(n+1)]


for _ in range(m):
    x,y = (map(int,input().split()))
    # 그래프의 인접성(에지간의 연결)을 2차원 배열로 표현 (연결 1, 미연결 0)
    EdgeList[x].append(y)
    EdgeList[y].append(x)
    
for i in range(0,n+1):
    EdgeList[i].sort(reverse=True)

# 방문에 대한 리스트 (방문 1, 미방문 0)
Visited = [0] *(n+1)

global cnt
cnt = 1

# vertex: 정점 집합 / edge: 간선 집합 / start : 시작노드
def RecursiveDfs(EdgeList,vertex,Visited):
    global cnt
    # 이미 방문한 버택스라면 호출함수 리턴
    Visited[vertex] = cnt
        
    # 이 호출로 방문하게된 정점의 인접 버택스를 방문하는데 그 중에서 작은놈 먼저 방문(오름차순)
    for k in EdgeList[vertex]:    
        if Visited[k] == 0 : 
            # 인접 노드가 출발 노드가 되어서 DFS 출발 
            cnt+=1
            RecursiveDfs(EdgeList,k,Visited)
    return

RecursiveDfs(EdgeList,start,Visited)


for k in range(1,n+1):
    print(Visited[k])


