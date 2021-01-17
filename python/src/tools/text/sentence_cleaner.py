import re

'''
Find common typos such as multiple spaces between words,
accidentally accidentally repeated words
 multiple exclamation marks at the end of sentences.
'''


def clean_sentence(sentence: str) -> str:
    sentence = sentence.capitalize()
    regex = re.compile(r'(!)+')
    sentence = regex.sub('!', sentence)
    regex = re.compile(r'(\s)+')
    sentence = regex.sub(' ', sentence)
    sentence = sentence.replace(" !", "!")
    sentence = re.sub(r'\b(\w+)( \1\b)+', r'\1', sentence)
    return sentence


def display_unique_lines():
    food_data = open(r'B:\GitHub\DomJavaKB\data\food.txt', encoding='UTF-8')
    content = food_data.readlines()
    result_list = []
    for line in content:
        items = line.split(',')
        for item in items:
            item = item.strip().lower()
            item = item.replace('\n', '').replace('• ', '') \
                .replace('The best: ', '').replace('and', '') \
                .replace('.', '').replace(')', '') \
                .replace('grass-fed', '').replace('unsweetened', '').strip()
            if item.endswith('s'):
                item = str(item[0:len(item) - 1])
            result_list.append(item)
    result_list = sorted(list(set(result_list)))

    # result
    for word in result_list:
        print(word)


def replace_all_these_with(items_list: list, with_item, content: str):
    for item in items_list:
        content = content.replace(item, with_item)
    return content


if __name__ == '__main__':
    display_unique_lines()
