def solution(numer1, denom1, numer2, denom2):
    
    up1 = numer1 * denom2
    up2 = numer2 * denom1
    down = denom1 * denom2
    up = up1 + up2

    for i in range(2, max(down, up)+1):
        if up < i or down < i : break
        while up % i == 0 and down % i % i == 0:
            up //= i
            down //= i
    return [up, down]


