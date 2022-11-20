
n, k = map(int,input().split())
dp = [0] * (k+1)
A = [None]*n
for i in range(n):
    
    w, v = list(map(int,input().split()))
    for j in range(k, w-1, -1):

        dp[j] = max(dp[j], dp[j-w] + v)
    #(W,V)

# 

# W1 + W2 +... < k
# V 가 최대인 경우를 구해야함

# W : 0    1    2    3    4    5    6    7
# V : 0    0    0    6    8    12   13   14


# 가방 무게의 최대 값 K 부터 역순으로 들어갈 물건의 무게 w까지 순회하면서 
# 해당 위치의 최대 가치(dp[j])와 들어갈 물건의 무게 w 만큼 이전의 최대 가치(dp[j-w])에
# 물건의 가치 v를 더한 값 중 최대값을 구한다.




print(dp[-1])
