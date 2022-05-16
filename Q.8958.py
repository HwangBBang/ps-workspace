n = int(input())
for i in range(n):
    ox = list(input())
    score = 0
    sum = 0
    for j in ox:
        if j=="O":
            score += 1
            sum += score
        else:
            score = 0
    print(sum)
