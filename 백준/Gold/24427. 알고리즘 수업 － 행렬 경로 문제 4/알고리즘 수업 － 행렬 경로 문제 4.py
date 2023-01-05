
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
dp = [[0 for _ in range(n+1)]for _ in range(n+1)]

# (1, 1)에서 (n,n)까지 아무 조건 없을 때 n x n dp 테이블 만드는 setDpTable함수 
def setDpTable(matrix):  
    for i in range(1,n+1):
        for j in range(1,n+1):
            dp[i][j] = matrix[i][j] + max(dp[i-1][j], dp[i][j-1])  
# setDpTable 함수 종료 

# p값을 제외한 모든 인덱스를 0으로 초기화하는 updateDpTable함수
def updateDpTable(pList):  
    for i in range(1,n+1):
        for j in range(1,n+1):
            if not (i,j) in pList:
                dp[i][j] = 0
            else:
                pass
# updateDpTable 함수 종료

# 정답을 찾는 findResult 함수
def findResult(matrix):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if not (dp[i][j-1] == 0) or not (dp[i-1][j] == 0):
                dp[i][j] = max(dp[i][j],matrix[i][j] + max(dp[i-1][j], dp[i][j-1]) )
    return dp[n][n]
# findResult 함수 종료 

# setDpTable 함수 호출
setDpTable(matrix)
# updateDpTable 함수 호출
updateDpTable(pList)
# findResult 함수 호출
print(findResult(matrix))






