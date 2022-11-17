S = input()

compare = "abcdefghijklmnopqrstuvwxyz"

for i in range(len(compare)):
    if compare[i] in S:
        print(S.index(compare[i]), end=" ")
    else:
        print(-1,end = " ")
