n = int(input())

arr = [1001] + list(map(int,input().split()))

# 가장 긴 증가하는 부분 수열을 구하기 위해서 어떻게해야할까 ? 
# 일단 메모지에이션을 하기위해 dp를 정의하고 dp[1]뭔지 찾아보자
# dp를 어떻게 정의해야할지 감이 오지않으니까 증가부분수열을 관찰해보자
# 10 - 1  / dp[1] = 1
# 10 20  - 2  / dp[2] = 2 
# 10 20 10  - 2 /  dp[3] = dp[2]  / arr[3] not > arr[2]
# 10 20 10 30  - 3 /  dp[4] = dp[3]  / arr[4] > arr[2]
# 10 20 10 30 20  - 3 /  dp[3] = dp[2]  / arr[3] not > arr[2]
# 10 20 10 30 20 50 -  4

# dp[끝나는 인덱스] =  끝나는 인덱스 일때 최장 부분 수열

dp = [1]*(n+1)


for i in range(2,n+1):
    for j in range(1,i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i],dp[j] + 1)

print(max(dp))