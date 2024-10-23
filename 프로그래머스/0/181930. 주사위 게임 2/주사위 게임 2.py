def solution(a, b, c):
    if a == b and b == c:
        answer = case1(a, b, c)
    elif a != b and b != c and a != c:
        answer = case3(a, b, c)
    else:
        answer = case2(a, b, c)
    return answer


def case1(a, b, c):
    return (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2)) * (pow(a, 3) + pow(b, 3) + pow(c, 3))


def case2(a, b, c):
    return (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2))


def case3(a, b, c):
    return (a + b + c)
