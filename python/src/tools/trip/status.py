import json

import bs4
import requests


def get_train():
    response = requests.get('https://www.nationalrail.co.uk/service_disruptions/indicator.aspx')
    temp = ''
    try:
        response.raise_for_status()  # without try it will exit program
        html_manager = bs4.BeautifulSoup(response.text, "html.parser")

        response = html_manager.select('tr.accordian-header')
        x = response[2].find_all('td')
        temp += x[0].text.replace(' Railways', '') + ': ' + x[1].text
    except Exception as whoops:
        print('Unable to get weather temperature due to : %s' % whoops)
    return temp


def get_tube():
    response = requests.get('https://api.tfl.gov.uk/line/mode/tube/status')
    data = json.loads(response.text)
    text = ''
    for i in data:
        if i['id'] == 'metropolitan' or i['id'] == 'jubilee' or i['id'] == 'victoria':
            text += i['id'].capitalize() + ': '
            for status in i['lineStatuses']:
                text += status['statusSeverityDescription'] + '\n'

    return text


def main():
    status = get_train() + '\n' + get_tube()
    print(status)


if __name__ == '__main__':
    main()
