S= input()

time = 0
for alpha in S:
    if alpha in 'ABC':
        time += 3
    elif alpha in 'DEF':
        time += 4
    elif alpha in 'GHI':
        time += 5
    elif alpha in 'JKL':
        time += 6
    elif alpha in 'MNO':
        time += 7
    elif alpha in 'PQRS':
        time += 8
    elif alpha in 'TUV':
        time += 9
    elif alpha in 'WXYZ':
        time += 10

print(time)