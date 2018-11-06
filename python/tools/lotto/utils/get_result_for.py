"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* Github:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
"""


def get_last(value):
    return value + 1


def get_result(data, remaining_numbers, how_many_values, numbers_drawn):
    for line in data[1: len(data)]:
        if len(remaining_numbers) > how_many_values:
            for i in range(1, get_last(numbers_drawn)):
                if line[i] in remaining_numbers:  # check if number exits in list
                    print(line[i])
                    remaining_numbers.pop(line[i])
                    if len(remaining_numbers) == how_many_values:
                        print("Result: " + str(remaining_numbers))
                        break
