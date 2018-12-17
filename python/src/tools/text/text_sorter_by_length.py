"""
1. open file
2. load file into list
3. sort by line length
4. save it
"""
import os

path = ''  # set path here!


def create_test_data(file_path):
    if file_path == '':
        file_path = os.getcwd() + 'test.file'
    test = ['acve', '3g5', 'fowjg3t', '5r4e3']
    file = open(file_path, 'w')
    for element in test:
        file.write(element)
        file.write('\n')
    file.close()
    return file_path


path = create_test_data(path)

data = open(path)

list = sorted(data, key=len, reverse=True)
for count, element in enumerate(list, start=1):
    element = element[:len(element) - 1]  # remove \n element from line
    print(str(count) + ": " + element + ' (length: ' + str(len(element)) + ')')
