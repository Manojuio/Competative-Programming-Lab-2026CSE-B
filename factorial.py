# Enter your code here. Read input from STDIN. Print output to STDOUT
n = int(input()) 

def f(n):
    if n == 1 or n == 0:
        return 1
    return n * f(n - 1)

t = f(n)
print(t)
