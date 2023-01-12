from collections import Counter

n = int(input())
sList = []

for _ in range(n):
    sList.append(input())

result = Counter(sList).most_common()
result.sort( key=lambda x :(-x[1], x[0]))
print(result[0][0])

