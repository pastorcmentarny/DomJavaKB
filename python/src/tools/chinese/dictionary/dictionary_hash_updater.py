"""
script to add hash to word in chinese dictionary,so i can connect sentence with it
"""

import uuid

# CONFIG
file_path = f'B:\GitHub\denva\src\data\dictionary.txt'


def update_dictionary_with_uuid():
    file = open(file_path, 'r', encoding="UTF-8", newline='')
    definition_lines = file.readlines()
    for definition_line in definition_lines:
        definition = definition_line.split(";;")
        if len(definition) != 11:
            if len(definition) == 12 and len(definition[10]) == 8:
                line = str(definition_line)
                line = line[0:len(line) - 2]
                print(line)
            else:
                print(f'WARNING: this line is invalid {definition_line} ({len(definition)})')
                print(len(definition[10]))
        else:
            line = str(definition_line)
            line = line[0:len(line) - 2]
            print(line + str(uuid.uuid4())[0:8] + ';;')


if __name__ == '__main__':
    update_dictionary_with_uuid()
