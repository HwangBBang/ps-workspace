import sys
input = sys.stdin.readline

n = int(input())

# (0, 0)에서 (n,n)까지 입력받을 행렬 생성
matrix = [[0 for _ in range(n+1)]for _ in range(n+1)]
# (1, 1)에서 (n,n)까지 행렬 값 입력받기
for i in range(1,n+1):
    matrix[i] = [0]+list(map(int,input().split()))

# 튜플로 이뤄진 p값들을 집합으로 관리하기 -> 가져올때 O(1)/ 어짜피 순서 필요 없음
pList = set()
for _ in range(int(input())):
    pList.add(tuple(map(int, input().split())))


# (0, 0)에서 (n,n)까지 dp 테이블 생성
dpPath0 = [[0 for _ in range(n+1)]for _ in range(n+1)]
dpPath1 = [[0 for _ in range(n+1)]for _ in range(n+1)]
dpPath2 = [[0 for _ in range(n+1)]for _ in range(n+1)]
dpPath3 = [[0 for _ in range(n+1)]for _ in range(n+1)]


# 경유지라면 다음 꺼에서 업데이트
# 경유지가 아니라면 현재꺼에서 업데이트 

# dpPath 0,1 업데이트
for i in range(1,n+1):
    for j in range(1,n+1):
        # 조건 경유지가 라면
        if (i,j) in pList:
            # dpPath0의 index (i,j) 이전항의 값이 하나라도 0이 아니라면
            if not (dpPath0[i][j-1] == 0) or not (dpPath0[i-1][j] == 0):
                # 경유지 한 개를 경유한 dpPath1를 업데이트 
                dpPath1[i][j] = matrix[i][j] + max(dpPath0[i-1][j], dpPath0[i][j-1])
            
        # 조건 경유지가 아니라면
        else:
            # (1, 1)에서 (n,n)까지 아무 조건 없을 때 n x n dp 테이블 만듦
            dpPath0[i][j] = matrix[i][j] + max(dpPath0[i-1][j], dpPath0[i][j-1])
            # dpPath1의 index (i,j) 이전항의 값이 하나라도 0이 아니라면
            if not (dpPath1[i][j-1] == 0) or not (dpPath1[i-1][j] == 0):
                # 경유지 한 개를 경유한 dpPath1를 업데이트 
                dpPath1[i][j] = matrix[i][j] + max(dpPath1[i-1][j], dpPath1[i][j-1])

#dpPath2 업데이트
for i in range(1,n+1):
    for j in range(1,n+1):
        # 조건 경유지가 라면
        if (i,j) in pList:
            #dpPath1의 index (i,j) 이전항의 값이 하나라도 0이 아니라면
            if not (dpPath1[i][j-1] == 0) or not (dpPath1[i-1][j] == 0):
            # 경유지 한 개를 경유한 dpPath2를 업데이트 
                dpPath2[i][j] = matrix[i][j] + max(dpPath1[i-1][j], dpPath1[i][j-1])
            
        # 조건 경유지가 아니라면
        else:
            # dpPath2의 index (i,j) 이전항의 값이 하나라도 0이 아니라면
            if not (dpPath2[i][j-1] == 0) or not (dpPath2[i-1][j] == 0):
                # 경유지 한 개를 경유한 dpPath1를 업데이트 
                dpPath2[i][j] = matrix[i][j] + max(dpPath2[i-1][j], dpPath2[i][j-1])

#dpPath3 업데이트
for i in range(1,n+1):
    for j in range(1,n+1):
        # 조건 경유지가 라면
        if (i,j) in pList:
            #dpPath2의 index (i,j) 이전항의 값이 하나라도 0이 아니라면
            if not (dpPath2[i][j-1] == 0) or not (dpPath2[i-1][j] == 0):
            # 경유지 한 개를 경유한 dpPath3를 업데이트 
                dpPath3[i][j] = matrix[i][j] + max(dpPath2[i-1][j], dpPath2[i][j-1])
            
        # 조건 경유지가 아니라면
        else:
            # dpPath3의 index (i,j) 이전항의 값이 하나라도 0이 아니라면
            if not (dpPath3[i][j-1] == 0) or not (dpPath3[i-1][j] == 0):
                # 경유지 한 개를 경유한 dpPath1를 업데이트 
                dpPath3[i][j] = matrix[i][j] + max(dpPath3[i-1][j], dpPath3[i][j-1])



if not (dpPath3[n][n] == 0):
    result = dpPath3[n][n]
else:
    result = -1
    
print(result)

