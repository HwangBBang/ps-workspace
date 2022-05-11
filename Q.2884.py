hour , min = map(int,input().split())
need  = int(input())
sum  = min+need
if min+need<60 :
    print(hour, min+need)
else :
    addH = sum // 60
    addM = sum % 60
    if hour+addH >= 24:
        hour=hour+addH-24
        if addH > 0:
            print(hour, sum-60*addH)
        else:
            print(hour, min+addM)
    else:
        if addH > 0:
            print(hour+addH, sum-60*addH)
        else:
            print(hour, min+addM)