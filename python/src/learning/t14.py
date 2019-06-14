import datetime
import subprocess
import time


def calc_prod():
    product = 1
    for i in range(1, product):
        product = product * i
        return product


start_time = time.time()
print(start_time)

prod = calc_prod()

finish_time = time.time()
print('The result is %s digits long.' % (len(str(prod))))
print('Took %s seconds calculate.' % (finish_time - start_time))

'''
Another way to profile your code is to use the cProfile.run() function, 
which provides a much more informative level of detail than the simple time.time() technique. 
The cProfile.run() function is explained at https://docs.python.org/3/library/profile.html.
'''

now = time.time()

print(now)
print(round(now))
print(round(now, 2))
print(round(now, 4))

now = datetime.datetime.now()
print(str(type(now)) + '    ' + str(now))
j_dt = datetime.datetime(2017, 4, 3, 15, 3, 0)
print(str(j_dt.day) + '.' + str(j_dt.month) + '\'' + str(j_dt.year) + ' @ ' + str(j_dt.hour) + ':' + str(j_dt.minute))

print(str(datetime.datetime.fromtimestamp(800000000)))  # datetime.datetime.fromtimestamp(10000000)

d_dt = datetime.datetime(1982, 7, 7, 19, 30, 0)

print(str(d_dt > j_dt))  # dates are compare on number based later is greater

print('then ? ' + str(datetime.datetime.fromtimestamp(datetime.datetime.now().timestamp() - d_dt.timestamp())))

# A timedelta object has the total duration represented in days, seconds, and microseconds.
# The total_seconds() method will return the duration in number of seconds alone
timedelta = datetime.timedelta(days=12)
print(str(timedelta))
print(str(now + timedelta))
'''
Be aware that pressing CTRL-C will not interrupt time.sleep() calls in IDLE. 
IDLE waits until the entire pause is over before raising the KeyboardInterrupt exception. 
To work around this problem, instead of having a single time.sleep(30) call to pause for 30 seconds, 
use a for loop to make 30 calls to time.sleep(1).
>>> for i in range(30):
    time.sleep(1)
'''

halloween2016 = datetime.datetime(2016, 10, 31, 0, 0, 0)

datetime_now = datetime.datetime.now()
delta = datetime.timedelta(seconds=3)
future = datetime_now + delta
print(str(future))

thirdApril2017 = datetime.datetime(2017, 4, 3, 15, 2, 0)

print(str(thirdApril2017.strftime("%d.%m(%b)'%Y [%w]")))
print(str(thirdApril2017.strftime("%d.%B'%y @ %H:%M:%S (%I:%M %p) # %A")))

# (The p in the name of the strptime() function stands for parse.)
print('mightyJ ' + str(datetime.datetime.strptime('April 3, 2017', '%B %d, %Y')))

for x in range(2):
    print(x)
    print('Tick')
    time.sleep(1)
    print('Tock')
    time.sleep(1)

time.sleep(2)

'''
 three different types of values used to represent time:

A Unix epoch timestamp (used by the time module) is a float or integer value of the number of seconds since 12 AM on January 1, 1970, UTC.

A datetime object (of the datetime module) has integers stored in the attributes year, month, day, hour, minute, and second.

A timedelta object (of the datetime module) represents a time duration, rather than a specific moment.
'''

# A Python program will not terminate until all its threads have terminated.

'''
: To avoid concurrency issues, never let multiple threads read or write the same variables. 
'''

subprocess.Popen('C:\\Windows\\System32\\calc.exe')
subprocess.Popen(['C:\\Windows\\notepad.exe', 'C:\\ds\\notes\\ds.txt'])

'''
The return value is a Popen object, which has two useful methods: poll() and wait().

Unlike importing the Python program as a module, when your Python program launches another Python program, the two are run in separate processes and will not be able to share each other’s variables.
'''

subprocess.Popen(['start', 'C:\\ds\\notes\\ds.txt'], shell=True)  # We also pass the shell=True keyword argument, which is needed only on Windows
