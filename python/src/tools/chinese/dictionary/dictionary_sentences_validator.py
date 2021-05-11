"""
validate dictionary
### id;;Hash;;type(S -sentence Q - question);;Chinese;;Pinyin;;Englishl;;Polish;;Word id;;Notes
"""

# CONFIG
columns = 9
file_path = f'B:\GitHub\denva\src\data\chinese_sentences.txt'


def display_failure(msg: str, line):
    print(f'Error: {msg}. Invalid line {line}')


def validate_dictionary() -> bool:
    file = open(file_path, 'r', encoding="UTF-8", newline='')
    definition_lines = file.readlines()
    counter = 0
    for definition_line in definition_lines:
        if definition_line.startswith('###'):
            print(f'this line is empty or a comment: {definition_line}, so it will be ignored')
        else:
            counter = counter + 1
            definition = definition_line.split(";;")
            if len(definition) != columns:
                display_failure(f'Incorrect number of columns should be {columns} but was {len(definition)}',
                                definition)
                return False

            try:
                id = int(definition[0])
                if id <= 0:
                    display_failure('Invalid ID', definition)
                    return False
            except Exception as exception:
                display_failure('Whoops. '.format(exception), definition)
                return False

            try:
                hash_id = definition[1]
                if not isinstance(hash_id, str) or len(hash_id) != 8:
                    display_failure('Invalid Hash', definition)
                    return False
            except Exception as exception:
                display_failure('Whoops. '.format(exception), definition)
                return False

    return True


if __name__ == '__main__':
    result = validate_dictionary()
    if result:
        print(f'Passed.')
    else:
        print(f'FAILED!')
