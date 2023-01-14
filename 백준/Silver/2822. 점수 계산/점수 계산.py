import sys
input = sys.stdin.readline

score =[]
sList =[]

for i in range(1,9):
    score.append((int(input()),i))

score.sort(key=lambda x: (-x[0],x[1]))

sum = 0
for i in range(5):
    sum += score[i][0]
    sList.append(score[i][1])

print(sum)
sList.sort()
print(*sList)
