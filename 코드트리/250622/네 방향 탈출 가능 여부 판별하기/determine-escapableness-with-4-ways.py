n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
visited=[[False]*m for _ in range(n)]
# Please write your code here.
from collections import deque

queue=deque()

dxs=[0,1,0,-1]
dys=[1,0,-1,0]
def rangeOut(x,y):
    if 0>x or n<=x or 0>y or m<=y:
        return True
    return False

def cango(cx,cy):
    for dx,dy in zip(dxs,dys):
        nx=cx+dx
        ny=cy+dy
        if rangeOut(nx,ny):
            continue
        if grid[nx][ny]==0:
            continue
        if visited[nx][ny]==True:
            continue
        queue.append([nx,ny])

        


queue.append([0,0])
def bfs():
    while queue:

        cx,cy=queue.popleft()
        if cx==n-1 and cy==m-1:
            print(1)
            return
        if visited[cx][cy]==True:
            continue
        visited[cx][cy]=True
        cango(cx,cy)
        # print(queue)
    
    print(0)
bfs()