n = int(input())

creatArr = []



for i in range(1,n+1):
    si = str(i)
    creatNum = i
    for j in range(len(si)):
        creatNum += int(si[j-1])
    if creatNum == n:
        creatArr.append(i)

if len(creatArr) == 0:
    print(0)
else:
    print(min(creatArr))