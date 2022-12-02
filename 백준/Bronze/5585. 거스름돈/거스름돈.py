m = int(input())

reM = 1000 - m
cnt = 0
while True:
    if reM == 0:
        break
    
    if reM // 500 > 0:
        cnt += reM // 500
        reM -= (reM // 500)*500

    elif reM // 100 > 0:
        cnt += reM // 100
        reM -= (reM // 100)*100

    elif reM // 50 > 0:
        cnt += reM // 50
        reM -= (reM // 50)*50


    elif reM // 10 > 0:
        cnt += reM // 10
        reM -= (reM // 10)*10

    elif reM // 5 > 0:
        cnt += reM // 5
        reM -= (reM // 5)*5

    elif reM // 1 > 0:
        cnt += reM // 1
        reM -= (reM // 1)*1


print(cnt)