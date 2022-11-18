S1,S2 = input().split()

S1 = S1[::-1]
S2 = S2[::-1]

S1=int(S1)
S2=int(S2)

if S1 >= S2:
    print(S1)
else:
    print(S2)