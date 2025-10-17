#두개의 정수를 입력 받아 
a,b=map(int,input().split(" "))
# 첫번재 수가 더 작으면 1을 아니면0을 출력하고 
if a<b:
    print(1,end=" ")
elif a>=b:
    print(0,end=" ")

# 두개의 수가 같으면 1 아니면 0을 출력하는 포로그램을 작성해주세요.
if a==b:
    print(1)
elif a!=b:
    print(0)
