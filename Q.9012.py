
import sys
class Stack:
    def __init__(self,value = None, item =[]):
        self.value = value 
        self.item = item
    def __len__(self):
        return len(self.item)
        
    def push(self,value):
        self.append(value)
    def pop(self):
        try:
            return self.pop()
        except IndexError:
            return -1
    def top(self):
        try:
            return self[-1]
        except IndexError:
            return -1
            
n = int(sys.stdin.readline().rstrip())

box = Stack();item = Stack()

for i in range(n):
    item = list(map(str, input().split()))
    for j in range(len(item)):
        if item[j] in '(':
            box.push(item[j])
        elif item[j] in ')':
            if len(box) > 0:
                box.pop()
            else:
                print("NO")
    if len(box) == 0:
        print("YES")
    else :
        print("NO")