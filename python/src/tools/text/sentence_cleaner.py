import re

'''
Find common typos such as multiple spaces between words,
accidentally accidentally repeated words
 multiple exclamation marks at the end of sentences.
'''


def clean_sentence(sentence: str) -> str:
    sentence = sentence.capitalize()
    regex = re.compile(r'(\s)+')
    sentence = regex.sub(' ', sentence)
    regex = re.compile(r'(very)+')
    sentence = regex.sub('', sentence)
    return sentence
