s = input()

sList = []

for i in range(0,len(s)):
    sList.append(s[i:])

sList.sort()

for j in sList:
    print(j)