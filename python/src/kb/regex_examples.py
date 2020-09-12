import re

### REGEX TESTER: https://pythex.org/.

#  Regular Expressions
phone = '415-555-4242 call me now!'
phone2 = '0415-555-4242'


def is_phone_number(text):
    if len(text) != 12:
        return False
    for i in range(0, 3):
        if not text[i].isdecimal():
            return False
    if text[3] != '-':
        return False
    for i in range(4, 7):
        if not text[i].isdecimal():
            return False
    if text[7] != '-':
        return False
    if i in range(8, 12):
        if not text[i].isdecimal():
            return False
    return True


phone = phone[0: 12]  # chunk unwanted text

print("Is phone:" + phone + " valid? " + str(is_phone_number(phone)))
print("Is phone:" + phone2 + " valid? " + str(is_phone_number(phone2)))

# Passing a string value representing your regular expression to re.compile() returns a Regex pattern object (or simply, a Regex object).

phoneNumberRegex = re.compile(r'\d{3}-\d{3}-\d{4}')
print(str(type(phoneNumberRegex)))

# Since regular expressions frequently use backslashes in them, it is convenient to pass raw strings to the re.compile()
# function instead of typing extra backslashes.
# Typing r'\d\d\d-\d\d\d-\d\d\d\d' is much easier than typing '\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d'.


mo = phoneNumberRegex.search('My number is 415-555-4242.')
print('Phone number found: ' + mo.group())

# to use regular expressions in Python:
"""
1.  Import the regex module with import re.
2.  Create a Regex object with the re.compile() function. (Remember to use a raw string.)
3.  Pass the string you want to search into the Regex object’s search() method. This returns a Match object.
4.  Call the Match object’s group() method to return a string of the actual matched text.
"""

# Passing 0 or nothing to the group() method will return the entire matched text.

phoneNumRegex2 = re.compile(r'(\d\d\d)-(\d\d\d-\d\d\d\d)')
mo = phoneNumRegex2.search('My number is 415-555-4242.')

print(f'group() gives {mo.group()}')
print(f'group(0) gives {mo.group(0)}')
print(f'mo.groups() gives {mo.groups()}')
areaCode, mainNumber = mo.groups()

print("Area:" + areaCode + " mainNumber:" + mainNumber)

# The \( and \) escape characters in the raw string passed to re.compile() will match actual parenthesis characters.

phoneNumberRegex3 = re.compile(r'\(\d\)')
mo = phoneNumberRegex3.findall('(1) (2) (3)-(4)')

for i in mo:
    print("group:" + i)

heroRegex = re.compile(r'John|Maria Smooth')
heroResult = heroRegex.search('John and Maria Smooth.')
print(heroResult.group())

batRegex = re.compile(r'Bat(man|mobile|bat)')
moon = batRegex.search('BatCave is not home for Batmobile.')
print(moon.group())

happyRegex = re.compile(r'(Ha){3,5}')

'''
one = happyRegex.search('Ha')
print(one.group())
two = happyRegex.search('HaHa')
print(two.group())
'''
three = happyRegex.search('HaHaHa')
print(three.group())
four = happyRegex.search('HaHaHaHa')
print(four.group())
five = happyRegex.search('HaHaHaHaHa')
print(five.group())
six = happyRegex.search('HaHaHaHaHaHa')
print(six.group())

# Making Your Own Character Classes

vowelRegex = re.compile(r'[aeiouAEIOU]')
robocop_sentence = 'Robocop eats baby food. BABY FOOD.'

result = vowelRegex.findall(robocop_sentence)
print("Result: " + str(result))

vowelRegex = re.compile(r'[a-zA-Z0-9]')
result = vowelRegex.findall(robocop_sentence)
print("Result: " + str(result))

#  A negative character class will match all the characters that are not in the character class.
constantRegex = re.compile(r'[^aeiouAEIOU]')
result = constantRegex.findall(robocop_sentence)
print("Result: " + str(result))
'''
# You can use the caret symbol (^) at the start of a regex
# to indicate that a match must occur at the beginning of the searched text.

# Likewise, you can put a dollar sign ($) at the end of the regex
# to indicate the string must end with this regex pattern.

# And you can use the ^ and $ together to indicate that the entire string must match the regex
'''

startWithHello = re.compile(r'^Hello')
result = startWithHello.search('Hello world!')
print(result)
print(startWithHello.search("He said Hello!") == None)
print(startWithHello.search("Hello my love!") == None)

endsWithNumber = re.compile(r'\d$')
print(endsWithNumber.search("You seat reservation is 52") == None)
print(startWithHello.search("Sit reservation is 3F") == None)

# the wild character . (to match . you need \. ) The dot-star will match everything except a newline.

atRegex = re.compile(r'.at')
result = atRegex.findall("The cat in the hat sat on the flat mat.")
print(str(result))

nameRegex = re.compile(r'First Name:(.*) Last Name: (.*)')
result = nameRegex.search('First Name: Dominik Last Name: Symonowicz')
print(result.group(1) + ' ' + result.group(2))

'''
The dot-star uses greedy mode: It will always try to match as much text as possible.
To match any and all text in a nongreedy fashion, use the dot, star, and question mark (.*?).
In the nongreedy version of the regex,
Python matches the shortest possible string: '<To serve man>'.
In the greedy version,
Python matches the longest possible string: '<To serve man> for dinner.>'.
'''
sentence = '<To serve man> for dinner.>'
nonGreedyRegex = re.compile(r'<.*?>')
nonGreedyResult = nonGreedyRegex.search(sentence)
print(nonGreedyResult.group())

greedyRegex = re.compile(r'<.*>')
greedyResult = greedyRegex.search(sentence)
print(greedyResult.group())

# Matching Newlines with the Dot Character re.DOTALL

sentence = 'Serve the public trust.\nProtect the innocent.\nUphold the law.'

noNewLineRegex = re.compile(r'.*')
print(str(noNewLineRegex.search(sentence).group()))

withNewLineRegex = re.compile(r'.*', re.DOTALL)
print(str(withNewLineRegex.search(sentence).group()))

'''
Review of Regex Symbols

This chapter covered a lot of notation, so here’s a quick review of what you learned:

The ? matches zero or one of the preceding group.

The * matches zero or more of the preceding group.

The + matches one or more of the preceding group.

The {n} matches exactly n of the preceding group.

The {n,} matches n or more of the preceding group.

The {,m} matches 0 to m of the preceding group.

The {n,m} matches at least n and at most m of the preceding group.

{n,m}? or *? or +? performs a nongreedy match of the preceding group.

^spam means the string must begin with spam.

spam$ means the string must end with spam.

The . matches any character, except newline characters.

\d, \w, and \s match a digit, word, or space character, respectively.

\D, \W, and \S match anything except a digit, word, or space character, respectively.

[abc] matches any character between the brackets (such as a, b, or c).

[^abc] matches any character that isn’t between the brackets.
'''

# Case-Insensitive Matching

regex1 = re.compile('RoBoCoP', re.IGNORECASE)  # you can use re.I or re.IGNORECASE
result = regex1.search("Robocop is awesome");
result2 = regex1.search("ROBOCOP IS AWESOME")
result3 = regex1.search("RoBoCoP is really awesome")
result4 = regex1.search("rObOcOp IS REALLY AWESOME")
print("and result are: " + result.group() + " " + result2.group() + " " + result3.group() + " " + result4.group())

# CHAPTER 7 REGEX

#  The ? character flags the group that precedes it as an optional part of the pattern.

batRegex = re.compile(r'Bat(wo)?man')

match1 = batRegex.search('The Adventures of the Batman')
print(match1.group())

match2 = batRegex.search('The Adventures of the Batwoman')
print(match2.group())

# The (wo)? part of the regular expression means that the pattern wo is an optional group.
# The regex will match text that has zero instances or one instance of wo in it.


phoneRegex = re.compile(r'(\d{3}-)?\d{3}-\d{4}')
match3 = phoneRegex.search('my number is 123-555-6666')
print(match3.group())

match4 = phoneRegex.search('my phone number is 555-6666')
print(match4.group())

# You can think of the ? as saying, “Match zero or one of the group preceding this question mark.”

# The * (called the star or asterisk) means “match zero or more”


batRegex = re.compile(r'Bat(wo)*man\*')

match5 = batRegex.search('The Adventure of the Batman*')
print(match5.group())

match6 = batRegex.search('The Adventure of the Batwoman*')
print(match6.group())

match7 = batRegex.search('The Adventure of the Batwowowowowowoman*')
print(match7.group())

# to match star character, prefix the star in the regular expression with a backslash, \*

# While * means “match zero or more,” the + (or plus) means “match one or more.”

batRegex = re.compile(r'Bat(wo)+man')

match8 = batRegex.search('The Adventures of the Batwoman')
print(match8.group())

match9 = batRegex.search('The Adventures of the Batwowowoman')
print(match9.group())

match10 = batRegex.search('The Adventures of the Batman')
print(match10 is None)

# While search() will return a Match object of the first matched text in the searched string,
# the findall() method will return the strings of every match in the searched string

numbers = 'Home: 328-817-908 Work: 754-839-4268'

phoneNumberRegex = re.compile(r'\d{3}-\d{3}-\d{4}')
mo = phoneNumberRegex.search(numbers)
print(mo.group())
mo = phoneNumberRegex.findall(numbers)
print(mo)

phoneNumberRegex = re.compile(r'(\d{3})-(\d{3})-(\d{4})')
mo = phoneNumberRegex.search(numbers)
print(mo.group())
mo = phoneNumberRegex.findall(numbers)
print(mo)

# findall() returns list of strings if regex has no groups
# findall() returns list of tuples of strings if regex has groups

# \d is shortcut for (0|1|2|3|4|5|6|7|8|9)
searchQuery = 'dOm1nIk 8866'
characterRegex = re.compile(r'\d')
result = characterRegex.search(searchQuery)
print('Should be "1" but is ' + result.group())

# \D is character that is not a numeric digit from 0-9
characterRegex = re.compile(r'\D')
result = characterRegex.search(searchQuery)
print('Should be "d" but is ' + result.group())

# \w is a word character (letter,digit or underscore)
characterRegex = re.compile(r'\w')
result = characterRegex.search(searchQuery)
print('Should be "d" but is ' + result.group())

# \W is any character that is not (letter,digit or underscore)
characterRegex = re.compile(r'\W')
result = characterRegex.search(searchQuery)
print('Should be " " but is ' + result.group())

# \s is a space character( any space,tab or new line)
characterRegex = re.compile(r'\s')
result = characterRegex.search(searchQuery)
print('Should be " " but is ' + result.group())

# \S is any character that is not space,tab or new line
characterRegex = re.compile(r'\S')
result = characterRegex.search(searchQuery)
print('Should be "d" but is ' + result.group())

# sub() menthod
censoredRegex = re.compile(r'Agent \w+')
censoredResult = censoredRegex.sub('CENSORED', "Agent Dom gave the secret documents to Agent Bobo")
print(censoredResult)

# In the first argument to sub(), you can type \1, \2, \3, and so on, to mean “Enter the text of group 1, 2, 3, and so on, in the substitution.”
agentNamesRegex = re.compile(r'Agent (\w)\w*')

result = agentNamesRegex.sub(r'\1****',
                             'Agent Alice told Agent Carol that Agent Eve knew Agent Bob was a double agent.')

print(result)

# the pipe character (|), which in this context is known as the bitwise or operator.
