import pyperclip

EMPTY = ''


def clean_result(results: str) -> str:
    cleaned_result = EMPTY
    lines = results.split('\n')
    temp_lines = []

    for line in lines:
        if line != EMPTY:
            temp_lines.append(line.strip())
    lines = temp_lines.copy()
    for idx in range(0, len(lines), 2):
        print(f'{idx} {lines[idx + 1]}')
        line = lines[idx].strip()[2:] + lines[idx + 1].strip()
        line = line.replace('Pick ', EMPTY).replace('-', EMPTY)
        if line.strip() != EMPTY and not line.replace(' ', EMPTY).isalpha():
            cleaned_result += f';0;{line.lstrip().replace(" ", ";")};\n'
    return cleaned_result.rstrip("\n")


results_input = """"""

if __name__ == '__main__':
    print('REMINDER! DO NOT FORGOT UPDATE INPUT BEFORE RUN IT')
    if results_input == '':
        print('^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^')
    else:
        result = clean_result(results_input)
        print(result)
        pyperclip.copy(result)
