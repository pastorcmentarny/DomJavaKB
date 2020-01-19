0. The ** operator is evaluated first
0. The *, /, //, and % operators are evaluated next, from left to right;
0. the + and - operators are evaluated last (also from left to right).

'''
Another way to profile your code is to use the cProfile.run() function, 
which provides a much more informative level of detail than the simple time.time() technique. 
The cProfile.run() function is explained at https://docs.python.org/3/library/profile.html.
'''