import csv

import bs4
import requests

from src.tools.lotto import config


def get_thunderball_data():
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


def get_euromillions_data():
    for year in range(2020, 2003, -1):
        response = requests.get('https://www.lottery.co.uk/euromillions/results/archive-' + str(year), 'html.parser')
        page = bs4.BeautifulSoup(response.text, "html.parser")
        div = page.select('.table.table.euromillions')[0].findAll('tr')

        for d in div:
            href = d.find('a')
            href = str(href)
            href = href[61:]
            href = href[:10]
            result = href + ','
            no = d.findAll('div')
            for n in no:
                result = result + str(n.text) + ','
            result = result[:len(result) - 1]
            print('0,' + result)


def add_draw_number():
    a_path = open(config.get_project_path('euro-all-draws.csv'))
    recent_draws_as_csv = csv.reader(a_path)
    recent_draws_as_list = list(recent_draws_as_csv)
    draws_with_no_list = []
    previous = 0
    for draw in recent_draws_as_list:
        draw_no = int(draw[0])
        if draw_no == 0:
            draw[0] = str(previous - 1)
            previous = previous - 1
        else:
            previous = int(draw[0])
        draws_with_no_list.append(draw)

    for x in draws_with_no_list:
        print(','.join(x))
