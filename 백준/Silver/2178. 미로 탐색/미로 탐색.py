from collections import deque
n,m = map(int,input().split())

g = [0 for _ in range(n)]
for i in range(n):
    g[i] = list(map(int,input()))

visited = [[0 for _ in range(m)]for _ in range(n)]

dxSet = [1,0,-1,0]
dySet = [0,1,0,-1]

def inRange(x,y):
    return 0 <=x and x<n and\
        0 <=y and y<m

def canShift(x,y):
    return inRange(x,y) and g[x][y] and not visited[x][y]

startX,startY = 0,0

def run(startX,startY):
    que = deque()
    que.append((startX,startY))
    while que:
        startX,startY = que.popleft()
        
        for dx,dy in zip(dxSet,dySet):
            nextX,nextY = startX+dx , startY+dy
            
            if canShift(nextX,nextY):
                visited[nextX][nextY]= visited[startX][startY] + 1
                que.append((nextX,nextY))
            

run(startX,startY)
print(visited[n-1][m-1]+1)