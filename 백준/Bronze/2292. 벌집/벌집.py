
N = int(input())
first = 1;plus = 6;room = 1
if N == 1:
    print(1)
else:
    while True:
        first = first + plus
        room+= 1
        if N <= first:
            print(room)
            break
        plus += 6