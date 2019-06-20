import sys

# example of increase recursion limit if you hit problem maximum recursion depth exceeded (Java StackOverflowError) in Jython

limit = sys.getrecursionlimit()
print('current recursion limit is:' + str(limit))
sys.setrecursionlimit(limit + 1000)
print('new recursion limit is :' + str(sys.getrecursionlimit()))
