import pyperclip

'''
How to use this tool:
* Copy text you are want add bullet point to each line too
* run program
* (text will copied to your clipboard) 
'''
NEW_LINE = '\n'

text = pyperclip.paste()

lines = text.split(NEW_LINE)

for i in range(len(lines)):
    lines[i] = '* ' + lines[i]

text = NEW_LINE.join(lines)

print(text)
pyperclip.copy(text)
