num = int(input())
for j in range (num):
    box = list(map(int, input().split()))
    aver = sum(box[1:])/box[0]
    count =0
    for i in  box[1:]:
        if aver < i:
            count +=1
    per = (count / box[0])*100
    print(f'{per:.3f}%')
