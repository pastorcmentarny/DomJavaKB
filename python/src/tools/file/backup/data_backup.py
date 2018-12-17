import datetime
import shutil


def get_double_digit_number(number):
    return "{0:0=2d}".format(number)


base_dir = '../../../../../'
source = base_dir + 'data/'
today = datetime.datetime.now()
destination_folder_name = str(today.year) + get_double_digit_number(today.month) + get_double_digit_number(today.day)
destination = base_dir + 'backup/' + destination_folder_name + "/"

print('source:' + source)
print('destination:' + destination)

shutil.copytree(source, destination)
