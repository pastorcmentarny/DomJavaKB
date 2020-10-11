import datetime
import os
import random  # import random
import re
import subprocess

import bs4
import requests
import sys
import time
from selenium import webdriver

name = None  # Python is dynamic, so you don't need to declare things;
counter = 0

while True:
    counter += 1

    password = random.randint(0, 100)
    print('trying guess password with ' + str(password))
    if password == 10:
        break

    print('Access DENIED')

print('Access granted. You needed ' + str(counter) + ' times to hack into this system. Enjoy reset of your mission...')

line = '====== -------- <  < <<>> >  > -------- ======'

# Math

print(3 * 5)
print(((2 + 2) * 2) ** (1 + 1))

# * operator used on one string and  integer is a   string replication operator.
print('string' * 6)

work = 37.5
print(work)
work = 'hello'
print(work)

# to use # comment use ctrl+/ shortcut
# print('type number 1:')
# a = int(input())
# print('type number 2:')
# b = int(input())
# print(a + b)


# Although the string value of a number is considered
# a completely different value from the integer or floating-point version,
# an integer can be equal to a floating point.

print(42 == '42')
print(42 == 42.00000)
print(42 == 0042.01)

# rouding The behavior of round() for floats can be surprising: for example, round(2.675, 2) gives 2.67 instead of the expected 2.68. This is not a bug: it’s a result of the fact that most decimal fractions can’t be represented exactly as a float. See Floating Point Arithmetic: Issues and Limitations for more information.

print(round(2.675, 2))

# The <, >, <=, and >= operators, on the other hand, work properly only with integer and floating-point values.

# The three Boolean operators (and, or, and not) are used to compare Boolean values.


# Python evaluates the not operators first, then the and operators, and then the or operators.


cats = [{'desc': 'chubby', 'name': 'Zophie'}, {'desc': 'fluffy', 'name': 'Pooka'}]

line = '====== -------- <  < <<>> >  > -------- ======'
# The ** operator is evaluated first; the *, /, //, and % operators are evaluated next, from left to right; and the + and - operators are evaluated last (also from left to right).
# Math


# * operator used on one string and  integer is a   string replication operator.
print('string' * 6)

work = 37.5
print(work)
work = 'hello'
print(work)

# input fun ,so not in use
# print('Warm welcome! Who are you ?')
# name = input()
# print()
# print('It is nice to meet you ' + name + '. You name is ' + str(len(name)) + ' characters long.')

# value that is passed to a function call is an argument.

print(len(''))
print('I am ' + str(34) + ' years old.')
varOfIntStringOrFloat = str(0)
print(varOfIntStringOrFloat)
piNumber = 3.14
varOfIntStringOrFloat = str(piNumber)
print(varOfIntStringOrFloat)
varOfIntStringOrFloat = int(piNumber)
print(varOfIntStringOrFloat)
varOfIntStringOrFloat = float(piNumber)
print(varOfIntStringOrFloat)
varOfIntStringOrFloat = float(10)

# print('type number 1:')
# a = int(input())
# print('type number 2:')
# b = int(input())
# print(a + b)


# Although the string value of a number is considered a completely different value from the integer or floating-point version, an integer can be equal to a floating point.
print(42 == '42')
print(42 == 42.00000)
print(42 == 0042.01)

# rouding The behavior of round() for floats can be surprising: for example, round(2.675, 2) gives 2.67 instead of the expected 2.68. This is not a bug: it’s a result of the fact that most decimal fractions can’t be represented exactly as a float. See Floating Point Arithmetic: Issues and Limitations for more information.

print(round(2.675, 2))

# the Boolean values True and False lack

t = True
f = False
print(t == f)

print()
# The <, >, <=, and >= operators, on the other hand, work properly only with integer and floating-point values.

# The three Boolean operators (and, or, and not) are used to compare Boolean values.

print(not ((4 > 3) or (3 >= 4)) and True)


# Python evaluates the not operators first, then the and operators, and then the or operators.


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

subprocess.Popen(['start', 'C:\\ds\\notes\\ds.txt'],
                 shell=True)  # We also pass the shell=True keyword argument, which is needed only on Windows

# inputSentence = '''
#  The setdefault() method is a nice shortcut to ensure that a key exists.
#   Here is a short program that counts the number of occurrences of each letter in a string.'''


result = 17 / 4 * 3 - 1 ** 2
print(result)

result = 17 // 3
print(result)

result = 17 // result + 17 % result
print(result)

result = 1j
print(result)

result = 1j ** 3  # need to learn how to use imaginary number
print(result)

# raw string If you don’t want characters prefaced by \ to be interpreted as special characters, you can use raw strings by adding an r before the first quote:
print(r'C:\to\nowhere')
print('C:\to\nowhere')

print('moon' * 10)

print('I wish Dominik pay more attention to coding'
      ' instead of wasting time on learning Python')

# Strings can be indexed (subscripted), with the first character having index 0 / However, out of range slice indexes are handled gracefully when used for slicing:


result = 'abcdefgh'

for character in result:
    print('character:' + character)

print(result[0], result[2])  # starts from 0 (first character)
print(result[-8], result[-6])  # starts from -1 (last character)

# slicing in string
result = 'Dominik'
print(result[:3] + result[3:])
print(result[0:3] + result[3:len(result)])

# String is immutable so you cannot do this result[0] = J but you can:
result = 'J' + result[1:]
print(result)

# Lists

result = [1, 4, 9, 16, 25]
print(result)
print(str(result[0]) + "::" + str(result[-5]))

# All slice operations return a new list containing the requested elements. This means that the following slice returns a new (shallow) copy of the list:

result += [36, 49, 64, 81, 100, 121]
print(result)
print('size: ' + str(len(result)))

# Unlike strings, which are immutable, lists are a mutable type, i.e. it is possible to change their content:

result[0] = 2
print(result)
result[0] = 1
result.append(12 ** 2)
print(result)

result[2:5] = []  # remove values for 3,4 and 5th element

print(result)
result[:] = []
print(result)

result = [[1, 3, 5, 7, 9], [2, 4, 6, 8]]
print(result[1][2])  # 6

var = 128 * 3
print('Value of var is', var)

# ]	Since ** has higher precedence than -, -3**2 will be interpreted as -(3**2) and thus result in -9. To avoid this and get 9, you can use (-3)**2.


# generate data
baseDir = "C:\\tmp\\python\\"
textFile = open(baseDir + "spam4-4-1984.txt", 'w')
textFile.write("spam spam spam")
textFile.close()

zipFile = open(baseDir + "01-03-2014eggs.zip", 'w')
zipFile.write("write something to zip file")
zipFile.close()

epubFile = open(baseDir + ' littlebrother.epub', 'w')
epubFile.write("an interesting epub")
epubFile.close()

datePattern = re.compile(r"""^(.*?)
    ((0|1)?\d)-
    ((0|1|2|3)?\d)-
    ((19|20)\d\d)
    (.*?)$
""", re.VERBOSE)

for americanFilename in os.listdir(baseDir):
    mo = datePattern.search(americanFilename)

    # skip files without dates
    if mo == None:
        continue

    beforePart = mo.group(1)
    monthPart = mo.group(2)
    dayPart = mo.group(4)
    yearPart = mo.group(6)
    afterPart = mo.group(8)
    print('result: ' + beforePart + monthPart + dayPart + yearPart + afterPart)
    abs_path = os.path.abspath(baseDir)
    americanFilePath = os.path.join(abs_path, americanFilename)
    euroFilename = beforePart + dayPart + '-' + monthPart + '-' + yearPart + afterPart
    euroFilenamePath = os.path.join(abs_path, euroFilename)

    print('Renaming "%s"  to "%s" ...' % (americanFilePath, euroFilenamePath))

print('Task complete, goodbye')

browser = webdriver.Firefox()
browser.get('http://inventwithpython.com')
try:
    elem = browser.find_element_by_class_name('bookcover')
    print('Found <%s> element with that class name!' % (elem.tag_name))
except:
    print('Was not able to find an element with that name.')

a = random.randint(0, 10)
b = random.randint(0, 10)
counter = 1

while a != b:
    counter += 1
    if a > b:
        print(str(a) + ' is greater than ' + str(b))
    elif a < b:
        print(str(a) + ' is smaller than ' + str(b))
    else:
        print(str(a) + ' is equal to ' + str(b))

    a = random.randint(0, 10)
    b = random.randint(0, 10)

print(
    'it took ' + str(counter) + ' attempts  to find 2 equals number randomly generated (' + str(a) + ',' + str(b) + ')')

while True:
    counter += 1
    if counter % 2000 == 0:
        print("bored")
        continue
    if counter % 1000 == 0:
        print(counter)
    if counter == 100001:
        break

# continue statements are used inside loops. When the program execution reaches a continue statement, the program execution immediately jumps back to the start of the loop and reevaluates the loop’s condition.

# “Truthy” and “Falsey” Values

for dom in range(5):
    print('No. ' + str(dom))

total = 0
for number in range(101):
    total += number
print(total)

for number in range(1, 11):
    print(number)

for number in range(1, 21, 2):
    print('odd:' + str(number))

for number in range(-1, -13, -3):
    print(number)

attempts = 100
for number in range(1, attempts):
    if random.randint(1, 20) == 7:
        print("7 is a lucky number. Goodbye! Shit happens on attempt: " + str(number) + '/' + str(attempts))
        sys.exit()
print("No seven,no problem")

url = 'http://xkcd.com'
path = r'C:\tmp\Python\xkcd\\'
os.makedirs(path, exist_ok=True)
while not url.endswith('#'):
    print('Downloading page %s...' % url)
    response = requests.get(url)
    response.raise_for_status()

    page = bs4.BeautifulSoup(response.text, "html.parser")

    elements = page.select('#comic img')

    if not elements:
        print('Not good. Could not find a comic image. Sorry :(')
    else:
        try:
            comicUrl = 'http:' + elements[0].get('src')
            print('Downloading image %s ..' % (comicUrl))
            imageFile = open(os.path.join('xkcd', path + os.path.basename(comicUrl)), 'wb')
            for chunk in response.iter_content(100000):
                imageFile.write(chunk)
            imageFile.close()
            prevLink = page.select('a[rel="prev"]')[0]
            url = 'http://xkcd.com' + prevLink.get('href')
        except requests.exceptions.MissingSchema:
            prevLink = page.select('a[rel="prev"]')[0]
            url = url + prevLink.get('href')
            continue

print('Done.')
