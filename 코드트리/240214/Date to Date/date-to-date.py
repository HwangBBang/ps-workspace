m1, d1, m2, d2 = map(int, input().split())
months = [0,31,28,31,30,31,30,31,31,30,31,30,31]

res = 0
for i in range(m1,m2+1):
    res += months[i]

res -= d1-1
res -= months[m2]-d2

print(res)