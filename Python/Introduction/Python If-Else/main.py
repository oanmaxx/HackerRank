#!/bin/python3

"""
Task: https://www.hackerrank.com/challenges/py-if-else/problem 
"""

if __name__ == '__main__':
    n = int(input().strip())
    if 1 <= n <= 100:
        if (n % 2 == 0) or ((n % 2 == 0) and (6 <= n <= 20)):
            print("Weird")
        elif (n % 2 == 0) and ((2 <= n <= 5) or (n < 20)):
            print("Not Weird")
