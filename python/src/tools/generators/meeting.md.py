import random

# SETTINGS:
title = 'TITLE'
agenda = ''

welcome = [
    'Warm welcome citizens!',
    'Dear Order Management Team',
    'D'
]

invite = [
    'You have been carefully selected to be in this',
    'I offer you an amazing opportunity to join',
    'Why not to join to another '
]

other = [
    "I would appreciate your immediate attention to the matter."
    "I/We regret to inform you that … ."
]


def new_line(times: int = 1) -> str:
    txt = '\n' * times
    return txt + '\t'


def get_random(message_list: list) -> int:
    return message_list[random.randint(0, len(message_list) - 1)]


if __name__ == '__main__':
    email = get_random(welcome)
    email += new_line(2)
    email += get_random(invite)
    email += " meeting about "
    email += title
    email += new_line(1)
    email += 'As always, if you have an questions '
    print(email)
