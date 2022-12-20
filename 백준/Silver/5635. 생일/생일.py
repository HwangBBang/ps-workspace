

n =int(input())

data = []
for _ in range(n):
    data.append(list(input().split()))
    
# 각 벨류 기준으로 정렬 

# How?

# 생일 이니까 
# 년 -> 년은 작을 수 록 나이 많다. 
# 월 -> 월 역시 작을 수록 나이 많다.
# 일 -> 일 역시 작을 수록 많다.

# [3] 먼저 오름차순 정렬
# [2] 먼저 오름차순 정렬
# [1] 먼저 오름차순 정렬

data = sorted(data,key = lambda x:(int(x[3]),int(x[2]),int(x[1])))


print(data[-1][0])
print(data[0][0])
# data[0][0] - > 가장 나이 많은 사람
# data[-1][0] - > 가장 나이 적은 사람