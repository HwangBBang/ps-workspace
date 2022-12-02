s = input()
S=[]
for elem in s:
    S.append(int(elem))

S.sort(reverse=True)

for elem in S:
    print(elem,end="")

