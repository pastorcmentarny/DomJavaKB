import pprint  # the pprint() and pformat() are useful method to make output looks “pretty” or more readable :)


def count_characters(inputSentence):
    character_counter = {}
    for character in inputSentence:
        character_counter.setdefault(character, 0)  # set default value if entry does not exists
        character_counter[character] += 1
    pprint.pprint(character_counter)


inputSentence = ''

while inputSentence is not len(inputSentence) < 1:
    print('type sentence to count characters in this sentence')
    inputSentence = input()
    if len(inputSentence) < 1:
        print('please try again')

count_characters(inputSentence)
