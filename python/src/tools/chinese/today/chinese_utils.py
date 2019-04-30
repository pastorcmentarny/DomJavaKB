import random


def get_random_value_from(type: list):
    return type[random.randint(0, len(type) - 1)]


def generate_sentence_from_multi_words(words: list) -> str:
    if len(words) == 1:
        return words[0]
    elif len(words) == 2:
        return words[0] + '和' + words[1]
    else:
        sentence = ''
        length = len(words)
        for idx, word in enumerate(words):
            if idx + 1 == length:
                sentence += '和' + word
            else:
                sentence += word
