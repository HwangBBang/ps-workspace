f = map(int,input().split())
s = map(int,input().split())
t = map(int,input().split())

def func(step):
    if  step == 0:
        return "D"
    if  step == 3:
        return "A"
    if  step == 2:
        return "B"
    if  step == 1:
        return "C" 
    if  step == 4:
        return "E"

print(func(sum(f)))
print(func(sum(s)))
print(func(sum(t)))