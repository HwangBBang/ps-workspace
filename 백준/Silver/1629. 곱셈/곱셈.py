import sys
sys.setrecursionlimit(10**6)

# ------------------------------------------------
# # 시간 초과 / O(b)으로는 안됨 O(log n)으로 생각
# for _ in range(b):
#     a *= a
# a%=c
# print(a)
# ------------------------------------------------
# # 메모리 초과 / dp 로 풀면 메모리 초과
# dpA = [None]*2147483647
# dpA[0]=a
# for i in range(1,b):
#     dpA[i] = dpA[i-1]*a

# dpA[b-1]%=c

# print(dpA[b-1])
# ------------------------------------------------

# 뭘까? O(log n) ~> 반갈 해야댐

def divideFunc(a,b):
    global c
    if b == 1:
        return a%c
    else:
        half = divideFunc(a, b // 2)
        # b 짝수 라면 그대로 반갈하면서 ㄱㄱ
        if b%2 == 0:
            return (half**2) % c
        # b 홀수 라면 a * a^(b-1) 반갈하면서 ㄱㄱ
        else :
            return (a * half**2) % c

global c 
a, b, c = map(int, sys.stdin.readline().split())

print(divideFunc(a,b))