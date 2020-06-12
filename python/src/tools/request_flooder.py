import requests
from timeit import default_timer as timer

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
    start_time = timer()

    get()  # choose action

    print('It took {} ms to delete data bin'.format(int((timer() - start_time) * 1000)))
