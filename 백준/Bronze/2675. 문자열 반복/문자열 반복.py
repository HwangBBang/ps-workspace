

t = int(input())

for _ in range(t):
    r,S = input().split()
    for i in range(len(S)):
        for _ in range(int(r)):
            print(S[i],end="")
    print()
