for _ in range(int(input())):
    arr = []
    
    for _ in range(int(input())):
        arr.append(list(input().split()))
    arr.sort(key=lambda x :-int(x[1]))
    print(arr[0][0])
        
        