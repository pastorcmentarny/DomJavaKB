import pyperclip

EMPTY = ''
NEW_LINE = '\n'


def clean_result(results: str) -> str:
    cleaned_result = EMPTY

    lines = results.split(NEW_LINE)
    for line in lines:
        if line.strip() != EMPTY and not line.replace(' ', EMPTY).isalpha():
            cleaned_result += f';0;{line.lstrip().replace(" ", ";")}{NEW_LINE}'
    return cleaned_result.rstrip(NEW_LINE)


results_input = """"""

if __name__ == '__main__':
    print('REMINDER! DO NOT FORGOT UPDATE INPUT BEFORE RUN IT')
    if results_input == EMPTY:
        print('^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^')
    result = clean_result(results_input)
    print(result)
    pyperclip.copy(result)
    print('REMINDER! DO NOT FORGOT TO SET input = """"""')
