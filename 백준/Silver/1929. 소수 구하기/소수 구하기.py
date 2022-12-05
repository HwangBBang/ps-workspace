m,n  = map(int, input().split())

# 시간초과
#/////////////////////////////////////
# def primeNum(num):
#     cnt = 0
#     for i in range(1,num):
#         if cnt > 1:
#             return False
#         if num%i == 0:
#             cnt+=1
#     return True

# # O(n-m)
# for j in range(m,n+1):
#     if primeNum(j) == True:
#         print(j)
#/////////////////////////////////////
# 에라토스테네스의 체
# 소수 판별 알고리즘
# 대량의 소수를 빠르게 판별 할 때 사용된다.

# 에라토스테네스의 체는 가장 먼저 소수를 판별할 범위만큼 배열을 할당 후
# 해당하는 값을 넣어주고, 이후에 하나씩 지워나가는 방법을 이용한다.

# 에라토스테네스의 체: 
# 범위에서 합성수를 지우는 방식으로 소수를 찾는 방법
# 1. 1은 제거 
# 2. 지워지지 않은 수 중 제일 작은 2를 소수로 채택, 나머지 2의 배수를 모두 지운다.
# 3. 지워지지 않은 수 중 제일 작은 3을 소수로 채택, 나머지 3의 배수를 모두 지운다.
# 4. 지워지지 않은 수 중 제일 작은 5를 소수로 채택, 나머지 5의 배수를 모두 지운다.
# 5. (반복)

Eratosthenes = [0,0] + [1]*(n-1)
primeNums = []

for i in range(2,n+1):
    #피벗이 소수라면?
    if Eratosthenes[i] == 1:
        # 소수 리스트에 어팬드 해준다
        primeNums.append(i)
        # 피벗의 배수들을 전부 소수판단 부울식을 0으로 초기화함
        for j in range(2*i,n+1,i):
            Eratosthenes[j] = 0

for i in range(0,len(primeNums)):
    if primeNums[i] >= m:
        print(primeNums[i])