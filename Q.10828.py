import sys

def push(value):
    item.append(value)
def pop():
    try:
        return item.pop()
    except IndexError:
        return -1
def size():
    return len(item)

def empty():
    if len(item) == 0:
        return 1
    else:
        return 0
def top():
    try:
        return item[-1]
    except IndexError:
        return -1
        
n = int(sys.stdin.readline().rstrip())

item=[];cmd_cut=0

for i in range(n):
    input_s = sys.stdin.readline().rstrip().split()
    cmd = input_s[0]
    if cmd == 'push':
        push(input_s[1])

    elif cmd == 'pop':
        print(pop())

    elif cmd == 'size':
        print(size())

    elif cmd == 'empty':
        print(empty())
        
    elif cmd == 'top':
        print(top())
