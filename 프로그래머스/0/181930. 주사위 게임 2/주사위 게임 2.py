
def solution(a, b, c):
    flagNum = len(list({a,b,c}))
    if flagNum == 1:
        return case1(a, b, c)
    elif flagNum == 2:
        return case2(a, b, c)
    elif flagNum == 3:
        return case3(a, b, c)


def case1(a, b, c):
    return (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2)) * (pow(a, 3) + pow(b, 3) + pow(c, 3))


def case2(a, b, c):
    return (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2))


def case3(a, b, c):
    return (a + b + c)
