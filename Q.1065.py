n = int(input())

def hansu (num):
    count = 0
    for k in range(1,num+1):
        nlist = list(map(int, str(k)))
        if k<100:
            count += 1
        elif nlist[0] - nlist[1] == nlist[1] - nlist[2]:
            count += 1
    return count

print(hansu(n))