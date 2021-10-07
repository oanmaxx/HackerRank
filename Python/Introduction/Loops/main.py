# Task: https://www.hackerrank.com/challenges/python-loops/problem

if __name__ == '__main__':
    n = int(input())
    if 1 <= n <= 20:
        i = 0
        while i < n:
            print(i ** 2)
            i += 1
