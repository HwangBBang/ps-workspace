t = int(input())
result = [0,0,0]

if t//300 > 0:
    result[0] += t//300
    t -= (t//300)*300

if t//60 > 0:
    result[1] += t//60
    t -= (t//60)*60

if t//10 > 0:
    result[2] += t//10
    t -= (t//10)*10

if t == 0: 
    for i in range(0,3):
        print(result[i],end=" ")
else:
    print(-1)