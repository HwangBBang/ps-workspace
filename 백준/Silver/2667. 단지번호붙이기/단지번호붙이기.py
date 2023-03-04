import sys
input = sys.stdin.readline

n = int(input())

# 입력받기 
g = [0]*(n+1)
g[0] = [0 for _ in range(n+1)]
for i in range(1,n+1):
    g[i] = [0]+list(map(int,input().rstrip()))

# 방문여부 확인을 위한.
visit = [[0 for _ in range(n+1)]for _ in range(n+1)]

# 결과 값을 위한 저장소
totalSection = 0
section = []
global cnt 
cnt = 0

# 범위 확인을 위한. 
def inRange(x,y):
    return 0<x and x<=n and \
        0<y and y<=n

# 연결이되었는지 확인을 위한
def isLinked(x,y):
    # 범위안이며, 방문한적없고, 유의미한 값이라면 -> 연결된 것으로 간주한다.
    return inRange(x,y)and not visit[x][y] and g[x][y]


# 이동을 위한
dxSet = [0,1,0,-1]
dySet = [1,0,-1,0]

def run(px,py):
    global cnt 
    # 현재
    visit[px][py] = 1
    cnt += 1
    for dx,dy in zip(dxSet,dySet):
        
        nx,ny = px+dx,py+dy
        
        if isLinked(nx,ny):
            run(nx,ny)



# 모든 경우를 탐색함 
for i in range(1,n+1):
    for j in range(1,n+1):
        cnt = 0
        if isLinked(i,j):
            totalSection += 1
            run(i,j)
            section.append(cnt)
    



print(totalSection)
section.sort()
for secNum in section:
    print(secNum)