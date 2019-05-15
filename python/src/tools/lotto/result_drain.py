import sys
import webbrowser

import bs4
import requests

for year in range(2018, 1998, -1):
    response = requests.get('https://www.lottery.co.uk/thunderball/results/archive-' + str(year), 'html.parser')
    page = bs4.BeautifulSoup(response.text, "html.parser")
    div = page.select('.table.table.thunderball')[0].findAll('tr')

    for d in div:

        href = d.find('a')
        href = str(href)
        href = href[53:]
        href = href[:10]
        result = href + ','
        no = d.findAll('div')
        for n in no:
            result = result + str(n.text) + ','
        result = result + 'T0,Odin,0'
        print(result)
