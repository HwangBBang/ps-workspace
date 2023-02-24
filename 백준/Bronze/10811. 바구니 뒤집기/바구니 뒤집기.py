n, m = map(int, input().split())

data = [i for i in range(n + 1)]

for _ in range(m) :
    i, j = map(int, input().split())
    value = []
    for k in range(i, j + 1) :
        value.append(data[k])
  
    value = value[::-1]
    number = 0
    for k in range(i, j + 1) :
        data[k] = value[number]
        number += 1

for k in range(1, len(data)) :
    print(data[k], end=' ')