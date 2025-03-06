def solution(x):
    
    sum = 0
    origin_x = x
    
    while True: 
        if x <= 0 :
            break
        y = x % 10
        x = x//10
        sum += y
        
    if origin_x % sum == 0:
        return True   
     
    return False