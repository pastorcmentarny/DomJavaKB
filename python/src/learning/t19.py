import bs4
import os
import requests

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
