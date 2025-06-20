n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

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
        queue.append([nx,ny])

        


queue.append([0,0])
def bfs():
    while queue:
        cx,cy=queue.popleft()
        if n==cx+1 and m==cy+1:
            queue.clear()
            print(1)
        grid[cx][cy]=0
        cango(cx,cy)
        # print(queue)
    if n!=cx+1 or m!=cy+1:
        print(0)
bfs()