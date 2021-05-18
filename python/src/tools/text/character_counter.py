import pprint  # the pprint() and pformat() are useful method to make output looks “pretty” or more readable :)


def count_characters(input_sentence):
    character_counter = {}
    for character in input_sentence:
        character_counter.setdefault(character, 0)  # set default value if entry does not exists
        character_counter[character] += 1
    pprint.pprint(character_counter)


sentence = ''

while sentence is not len(sentence) < 1:
    print('type sentence to count characters in this sentence')
    sentence = input()
    if len(sentence) < 1:
        print('please try again')

count_characters(sentence)
