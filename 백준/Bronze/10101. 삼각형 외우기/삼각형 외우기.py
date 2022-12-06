
import sys
input = sys.stdin.readline

arr=[0,0,0]

for i in range(3):
    arr[i] = int(input())

if sum(arr) == 180:
    if arr[0] == arr[1] == arr[2]:
        print("Equilateral")
    elif arr[0] != arr[1] and arr[1] != arr[2] and arr[0] != arr[2]:
        print("Scalene")
    else:
        print("Isosceles")
else:
    print("Error")
    
