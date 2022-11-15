import sys
input = sys.stdin.readline

dpSet = {}


def w(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    if a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)

    key = '{} {} {}'.format(a, b, c)

    if key in dpSet:
        return dpSet[key]
    result = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    dpSet[key] = result
    
    return result


while 1:
    a, b, c = map(int, input().split())
    if a == -1 and b == -1 and c == -1:
        break
    print('w({}, {}, {}) = {}'.format(a, b, c, w(a, b, c)))
