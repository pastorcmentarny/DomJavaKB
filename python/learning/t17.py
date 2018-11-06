import os
import re

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

from selenium import webdriver
browser = webdriver.Firefox()
browser.get('http://inventwithpython.com')
try:
    elem = browser.find_element_by_class_name('bookcover')
    print('Found <%s> element with that class name!' % (elem.tag_name))
except:
    print('Was not able to find an element with that name.')

import random  # import random
import sys

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

