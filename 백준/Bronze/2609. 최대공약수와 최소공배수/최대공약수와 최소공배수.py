
n,m = map(int,input().split())

def gcd_mod(a, b):
    while a!=0 and b!=0:
        if a>b: a = a%b
        else: b = b%a
    return a+b

def func2(a,b):
    addA , addB = a,b
    while True:
        if a == b:
            return a
        else:
            if a>b:
                b += addB
            if a<b:
                a += addA

print(gcd_mod(n,m))
print(func2(n,m))