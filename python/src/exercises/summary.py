shopping_items = {'temp': 2,
                  'humidity': 6,
                  'uv': 1,
                  'Db': 65,
                  'brightness': 8000
                  }


def shopping_list(items, left_width, right_width):
    print_title(left_width, right_width)
    print_items(items, left_width, right_width)


def print_items(items, left_width, right_width):
    for k, v in items.items():
        print(k.ljust(left_width, '.') + str(v).rjust(right_width, ' '))


def print_title(left_width, right_width):
    print('INFO'.center(left_width + right_width, "-"))


shopping_list(shopping_items, 20, 6)
