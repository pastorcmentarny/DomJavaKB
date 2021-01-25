import pyperclip

NEW_LINE = "\n"
EMPTY = ''
SPACE = " "


def clean_result(results: str) -> str:
    cleaned_result = EMPTY
    temp_lines = []
    lines = results.split('\n')
    for line in lines:
        if line != EMPTY and not line.strip().isalpha():
            temp_lines.append(line.strip())
    lines = temp_lines.copy()
    for idx in range(0, len(lines), 2):
        line = f'{lines[idx].strip()};{lines[idx + 1].strip()}'
        if line.strip() != EMPTY and not line.replace(' ', EMPTY).isalpha():
            cleaned_result += f';{line.lstrip().replace(SPACE, ";")};0;\n'
    return cleaned_result.rstrip(NEW_LINE)


results_input = """"""

if __name__ == '__main__':
    print('REMINDER! DO NOT FORGOT UPDATE INPUT BEFORE RUN IT')
    if results_input == '':
        print('^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^')
    result = clean_result(results_input)
    print(result)
    pyperclip.copy(result)
    print('REMINDER! DO NOT FORGOT TO SET input = """"""')
