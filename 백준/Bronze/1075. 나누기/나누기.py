n=int(input())
f=int(input())

lastTwo=(n//100)*100%f 

answer = f - lastTwo 

if answer!=f: #A!=F 대신 R!=0으로 해도 됨.
    if answer<10:
        print("0"+str(answer)) 
    elif answer>=10 and answer<100:
        print(answer) 
    else:
        print("00") 
else:
    print("00")