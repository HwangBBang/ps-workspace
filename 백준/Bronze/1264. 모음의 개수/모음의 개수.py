


def count(s):
    dic = ["a","e","i","u","o"]
    cnt = 0
    for elem in s:
        if elem in dic:
            cnt +=1
    return cnt 


while 1:
    n=input()
    n = n.lower()
    if n =='#':
        break
    print(count(n))

