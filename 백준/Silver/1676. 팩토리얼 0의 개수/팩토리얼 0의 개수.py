import sys
# input = sys.stdin.readline

n = int(input())

dp = [0]*(501)
dp[0] = 1
dp[1] = 1
cnt = 0
if n != 0:
    for i in range(2,n+1):
        dp[i] = dp[i-1]*i

    arr=str(dp[n])


    for i in range (len(arr)-1,-1,-1):
        if arr[i] == '0':
            cnt += 1
        else:
            break

print(cnt)