import requests
import time

url = "http://localhost:8080/promotions"

data = '''{
 "name" : "value"
}'''

number_of_requests = 10000


def get():
    for i in range(number_of_requests):
        requests.get(url)


def get_with_json():
    for i in range(number_of_requests):
        requests.get(url, data=data)


if __name__ == '__main__':
    start = time.time()

    get()  # choose action

    stop = time.time()
    print('it took {} milliseconds.'.format((stop - start)))
