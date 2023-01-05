
n = int(input())
matrix = [[0 for _ in range(n+1)]for _ in range(n+1)]

dp = [[0 for _ in range(n+1)]for _ in range(n+1)]

matrix[0] = [0]*(n+1)
for i in range(1,n+1):
    matrix[i] = [0]+list(map(int,input().split()))

x,y = map(int, input().split())

def matrix_path1(matrix, x,y):  # (1, 1)에서 반드시(x,y)포함 (n, n)에 이르는 최고 점수를 구한다.
    for i in range(1,x+1):
        for j in range(1,y+1):
            dp[i][j] = matrix[i][j] + max(dp[i-1][j], dp[i][j-1])  
    
    for i in range(x,n+1):
        for j in range(y,n+1):
            dp[i][j] = matrix[i][j] + max(dp[i-1][j], dp[i][j-1])  # 코드2
            
    return dp[n][n]

def matrix_path2(matrix, x,y):  # (1, 1)에서 반드시 (x,y)미포함(n, n)에 이르는 최고 점수를 구한다.
    
    for i in range(1,n+1):
        for j in range(1,n+1):
            if x == i and y == j:
                dp[i][j] = 0 
            
            else:
                if dp[i-1][j] == 0 and dp[i][j-1] == 0 :
                    dp[i][j] =  max(dp[i-1][j], dp[i][j-1])  
                else:
                    dp[i][j] = matrix[i][j] + max(dp[i-1][j], dp[i][j-1])  
            dp[1][1] = matrix[1][1] # y 는 1 1 이 아님 그래서 ㄱㅊ
    
            
    return dp[n][n]

result1 = matrix_path1(matrix,x,y)
dp = [[0 for _ in range(n+1)]for _ in range(n+1)]
result2 = matrix_path2(matrix,x,y)


print(result1,result2)


