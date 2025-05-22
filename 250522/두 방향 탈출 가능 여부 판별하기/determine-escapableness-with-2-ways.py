def rangeOut(row,column,N,M):
    if row < 0 or row >= N or column < 0 or column >= M:
        return True
    return False
def end(cC,cR,r,c):
    if cC==c-1 and cR==r-1:
        return True
    return False

def sol(currentC,currentR,row,column,grid):
    dR=[1,0]
    dC=[0,1]
    if end(currentC,currentR,row,column):
        return
    for i in range(2):
        nR=currentR+dR[i]
        nC=currentC+dC[i]
        
        if rangeOut(nR,nC,row,column):
            continue
        if grid[nR][nC] != 1:
            continue
        
        
        grid[nR][nC]="X"
        # print(grid)
        sol(nC,nR,row,column,grid)




N,M=map(int,input().split())
grid=[[0] for _ in range(M)]
# print(grid)
for i in range(N):
    grid[i]=list(map(int,input().split()))
    # print(grid)
currentR=0
currentC=0
sol(currentC,currentR,M,N,grid)
if grid[M-1][N-1]==1:
    print(0)
else:
    print(1)