import pyperclip


def clean_result(results: str) -> str:
    cleaned_result = ""
    lines = results.split('\n')
    for line in lines:
        if line.strip() != '' and not line.replace(' ', '').isalpha():
            cleaned_result += f';0;{line.lstrip().replace(" ", ";")};\n'
    return cleaned_result.rstrip("\n")


if __name__ == '__main__':
    result = clean_result(pyperclip.paste())
    print(result)
    pyperclip.copy(result)
