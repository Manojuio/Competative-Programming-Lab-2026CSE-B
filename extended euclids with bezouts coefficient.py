import sys

def extended_gcd(a, b):
    """Returns (gcd, x, y) such that a*x + b*y = gcd"""
    if a == 0:
        return b, 0, 1
    g, x1, y1 = extended_gcd(b % a, a)
    x = y1 - (b // a) * x1
    y = x1
    return g, x, y

def solve():
    # Read A and B from standard input
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    a = int(input_data[0])
    b = int(input_data[1])
    
    g, x0, y0 = extended_gcd(a, b)
    step_x = b // g
    step_y = a // g
    
    
    k_center1 = -x0 // step_x
    k_center2 = y0 // step_y
    
    min_k = min(k_center1, k_center2) - 2
    max_k = max(k_center1, k_center2) + 2
    
    best_sum = float('inf')
    best_x, best_y = None, None
    
    for k in range(min_k, max_k + 1):
        x = x0 + k * step_x
        y = y0 - k * step_y
        
        current_sum = abs(x) + abs(y)
        
        if current_sum < best_sum:
            best_sum = current_sum
            best_x, best_y = x, y
        elif current_sum == best_sum:
            
            if (x <= y and not (best_x <= best_y)) or (x <= y and best_x <= best_y and x < best_x):
                best_x, best_y = x, y
                
    print(f"{best_x} {best_y} {g}")

if __name__ == '__main__':
    solve()