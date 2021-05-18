import sys
import webbrowser

import bs4
import requests

result = webbrowser.open('https://github.com/pastorcmentarny')
print(result)

response = requests.get('https://automatetheboringstuff.com/files/rj.txt')
type(response)
if response.status_code == requests.codes.ok:
    print(str(response.status_code))
print(str(response))
print(str(len(response.text)))
print(response.text[1:250])

response = requests.get('http://inventwithpython.com/page_that_does_not_exist')
try:
    response.raise_for_status()  # without try it will exit program
except Exception as whoops:
    print('There was a problem: %s' % whoops)

# Even if the page is in plaintext (such as the Romeo and Juliet text you downloaded earlier),
#  you need to write binary data instead of text data in order to maintain the Unicode encoding of the text.


bookFile = open('RandJ.txt', 'wb')
for chuck in response.iter_content(100000):
    progress = bookFile.write(chuck)
    print('Saving :' + str(progress))

bookFile.close()

response = requests.get('http://nostarch.com', 'html.parser')
response.raise_for_status()
htmlManager = bs4.BeautifulSoup(response.text)
print(type(htmlManager))

print(htmlManager.select('div'))
print('AUTHOR')
print(htmlManager.select('#author'))  # id
print(htmlManager.select('.notice'))  # class

response = requests.get('https://automatetheboringstuff.com/chapter11/', 'html.parser')
page = bs4.BeautifulSoup(response.text)

div = page.select('.entry-content')
print(type(div))
print(len(div))
text = div[0]
print(text)

div = page.select('.footnote')
print(type(div))
print(len(div))
text = div[0]
print(text)
print(div[0].attrs)
print(div[0].getText())
print(div[0].get('class'))

print('Goggling..')

google = 'http://google.com/'

if sys.argv[1:] is not None:
    searchQuery = sys.argv[1:]
else:
    print('search queary not found in program argument. Using my name as example')
    searchQuery = 'Dominik Symonowicz'
response = requests.get(google + 'search?q=' + searchQuery)
response.raise_for_status()

page = bs4.BeautifulSoup(response.text, "html.parser")
links = page.select('.r a')

numOpen = min(5, len(links))
for i in range(numOpen):
    webbrowser.open(google + links[i].get('href'))
