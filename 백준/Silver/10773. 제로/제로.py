def push(n):
    stack.append(n)


def pop():
    if empty() == 1:
        return -1
    else:
        return stack.pop()


def size():
    return len(stack)


def empty():
    if size() == 0:
        return 1
    else:
        return 0


def top():
    if empty():
        return -1
    else:
        return stack[size()-1]


K = int(input())
stack = [0]
for _ in range(K):
    
    val = int(input())
    if val == 0:
        pop()
    else:
        push(val)

print(sum(stack))
