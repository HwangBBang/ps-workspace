import sys
input = sys.stdin.readline

n = int(input())


# 비트마스킹을 활용하자. - > 메모리 절약 할 수 있음
# 비트마스킹이란?
# 이진수로 표현되는 자료들을 이용하는 기법
# 비트연산자 
# &  :  and
# |  :  or
# ^  :  xor
# ~  :  not
# << :  left shift
# >> :  right shift





S = 0

for _ in range(n):
    cmd = input().rstrip().split()

    if cmd[0] == "all":
        S = (1 << 20) - 1

    elif cmd[0] == "empty":
        S = 0

    elif cmd[0] == "add":
        S |= (1 << int(cmd[1]) - 1)
    
    elif cmd[0] == "remove":
        S &= ~(1 << int(cmd[1]) - 1)
    
    elif cmd[0] == "check":
        print(1 if S & (1 << int(cmd[1]) - 1) else 0)
    
    elif cmd[0] == "toggle":
        S ^= (1 << int(cmd[1]) - 1)

