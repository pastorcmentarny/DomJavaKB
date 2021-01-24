import pyperclip


def clean_result(results: str) -> str:
    cleaned_result = ""
    lines = results.split('\n')
    temp_lines = []
    for line in lines:
        if line != '':
            temp_lines.append(line.strip())
    lines = temp_lines.copy()
    for idx in range(0, len(lines), 2):
        print(f'{idx} {lines[idx+1]}')
        line = lines[idx].strip()[2:] + lines[idx + 1].strip()
        line = line.replace('Pick ', '').replace('-', '')
        if line.strip() != '' and not line.replace(' ', '').isalpha():
            cleaned_result += f';0;{line.lstrip().replace(" ", ";")};\n'
    return cleaned_result.rstrip("\n")


if __name__ == '__main__':
    result = clean_result(pyperclip.paste())
    print(result)
    pyperclip.copy(result)
