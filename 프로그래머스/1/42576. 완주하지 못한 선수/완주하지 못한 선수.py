from  collections import Counter 
def solution(participant, completion):
    answer = ''
    # for c in completion:
    #     participant.remove(c)
    # answer = participant[0]
    
    
        
    
    answer = list((Counter(participant) -Counter(completion)).keys())[0]
    return answer