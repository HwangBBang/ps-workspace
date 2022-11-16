    #킹,퀀,룩,비숍,나이트,폰

# A = [0,0,0,0,0,0]
# king, queen, rook, bishop, knight, pawn
A = list(map(int,input().split()))

B =[1,1,2,2,2,8]

C = [ B[i]-A[i] for i in range(len(A))]

for i in range(len(A)):
    print (C[i],end= " ")