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




T = int(input())

for _ in range(T):
    stack = []
    sample = input()
    
    for i in range(len(sample)):
        
        if sample[i] == "(":
            push("(")
        else:
            # 스택이 비어있다면?
            if top() == -1: 
            # 비어 있는데 이거가 들어왔으니 NO!
                push(")")
                break
            # 스택이 비어있있지 않다면?
            else:
                # 가장 위에 것을 pop
                pop()
    # for 문을 다 돌았을 때 스택이 empty라면? -> YES
    if empty() == 1:
        print("YES")
    else:
        print("NO")
