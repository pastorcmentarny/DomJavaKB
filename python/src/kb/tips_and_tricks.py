from getpass import getpass

number_as_one = 1000000
number_with_separator = 1_000_000

print(number_as_one)
print(f'{number_as_one:,}')  # add separator for better number read
print(number_with_separator)

aircraft_manufacturer = ['Airbus', 'Airbus', 'Boeing']
aircraft_model = ['A380', 'A350', '787']
aircraft_type = ['800', '900ULR', '10']

for a_manufacturer, a_model, a_type in zip(aircraft_manufacturer, aircraft_model, aircraft_type):
    print(f'{a_manufacturer} {a_model}-{a_type}')

first, second = ('cheese', 'cake')

print('{}{}'.format(first, second))

username = input('Username: ')
with_password = False  # it doesnt work with IDE
if with_password:
    password = getpass('Password: ')

print('Logging in..')

isinstance(number_as_one, int)  # True


def is_phone_number(text):
    if len(text) != 12:
        pass
