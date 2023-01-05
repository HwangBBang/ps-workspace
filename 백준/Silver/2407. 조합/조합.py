# 풀이 1
import math
n,m = map(int,input().split())
print(math.comb(n,m))

# 풀이 2
# result = 1
# for i in range(n,n-m,-1):
#     # 분자 
#     result *= i

# for i in range(m,0,-1):
#     # 분모 
#     result //= i
    
# print(result)
