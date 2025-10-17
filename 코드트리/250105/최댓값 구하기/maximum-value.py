a,b,c=input().split()
a=int(a)
b=int(b)
c=int(c)
if b<=a and c<=a:
    res=a
elif a<=b and c<=b:
    res=b
else:
    res=c
print(res)