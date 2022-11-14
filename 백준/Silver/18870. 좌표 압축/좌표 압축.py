import sys

n = int(sys.stdin.readline())

A = list(map(int ,sys.stdin.readline().split()))

# set 으로 중복 제거
APrime = sorted(set(A))

# 사전에 저장하고 해당하는 찾아올거임 / 메모리창고
dict = {
    APrime[idx]: idx for idx in range(0, len(APrime), 1)
    }

for elem in A:  
    print(dict[elem], end=' ')

