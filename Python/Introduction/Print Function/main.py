# Task: https://www.hackerrank.com/challenges/python-print/problem

if __name__ == '__main__':
    n = int(input())
    if 1 <= n <= 150:
        i = 1
        while i <= n:
            print(i, end="")
            i += 1
