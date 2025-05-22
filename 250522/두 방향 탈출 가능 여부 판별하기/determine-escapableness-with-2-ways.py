def rangeOut(nextRow,nextColumn):
    global n
    global m
    return nextRow < 0 or nextRow >= n or nextColumn < 0 or nextColumn >= m # true 
    


def sol(r,c):    
    global n
    global m
    global result
    if r == n-1 and c == m-1:
        result = 1
        return
    
    for i in range(2):
        nR = r+dR[i]
        nC = c+dC[i]
        
        if rangeOut(nR,nC): continue
        if grid[nR][nC] == 0: continue
        
        sol(nC,nR)



global n
global m
global result

dR=[1,0]
dC=[0,1]
result = 0

n,m = map(int,input().split())

grid = []
for i in range(n):
    grid.append(list(map(int,input().split())))


sol(0,0)
print(result)