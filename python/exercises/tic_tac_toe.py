# my version of tic tac toe
import random

PLAYER_O = 'O'
PLAYER_X = 'X'

COMMA = ','
LOW_LEFT = 'lL'
LOW_MIDDLE = 'lM'
LOW_RIGHT = 'lR'
MID_LEFT = 'mL'
MID_MIDDLE = 'mM'
MID_RIGHT = 'mR'
TOP_LEFT = 'tL'
TOP_MIDDLE = 'tM'
TOP_RIGHT = 'tR'
LINE_SEPARATOR = '-+=+-'
SEPARATOR = '|'
EMPTY = ' '
theBoard = {TOP_LEFT: EMPTY, TOP_MIDDLE: EMPTY, TOP_RIGHT: EMPTY,
            MID_LEFT: EMPTY, MID_MIDDLE: EMPTY, MID_RIGHT: EMPTY,
            LOW_LEFT: EMPTY, LOW_MIDDLE: EMPTY, LOW_RIGHT: EMPTY}


def print_board(board):
    print(board[TOP_LEFT] + SEPARATOR + board[TOP_MIDDLE] + SEPARATOR + board[TOP_RIGHT])
    print(LINE_SEPARATOR)
    print(board[MID_LEFT] + SEPARATOR + board[MID_MIDDLE] + SEPARATOR + board[MID_RIGHT])
    print(LINE_SEPARATOR)
    print(board[LOW_LEFT] + SEPARATOR + board[LOW_MIDDLE] + SEPARATOR + board[LOW_RIGHT])


def get_possible_moves():
    moves = ''
    for moveElement in moveList:
        moves += moveElement + COMMA
    return moves[0:len(moves) - 1]


def swap_player():
    global turn
    if turn == PLAYER_X:
        turn = PLAYER_O
    else:
        turn = PLAYER_X


def get_player_name_randomly():
    return PLAYER_X if random.getrandbits(1) else PLAYER_O


turn = get_player_name_randomly()

moveList = (TOP_LEFT, TOP_MIDDLE, TOP_RIGHT, MID_LEFT, MID_MIDDLE, MID_RIGHT, LOW_LEFT, LOW_MIDDLE, LOW_RIGHT)


def diagonal_lines(current_player):
    return is_whole_line_belong_to_player(current_player, TOP_LEFT, MID_MIDDLE, LOW_RIGHT) \
           or is_whole_line_belong_to_player(current_player, TOP_RIGHT, MID_MIDDLE, LOW_LEFT)


def vertical_lines(current_player):
    return is_whole_line_belong_to_player(current_player, TOP_LEFT, MID_LEFT, LOW_LEFT) \
           or is_whole_line_belong_to_player(current_player, TOP_MIDDLE, MID_MIDDLE, LOW_MIDDLE) \
           or is_whole_line_belong_to_player(current_player, TOP_RIGHT, MID_RIGHT, LOW_RIGHT)


def horizontal_lines(current_player):
    return is_whole_line_belong_to_player(current_player, TOP_LEFT, TOP_MIDDLE, TOP_RIGHT) \
           or is_whole_line_belong_to_player(current_player, MID_LEFT, MID_MIDDLE, MID_RIGHT) \
           or is_whole_line_belong_to_player(current_player, LOW_LEFT, LOW_MIDDLE, LOW_RIGHT)


def current_player_won(current_player):
    return horizontal_lines(current_player) or vertical_lines(current_player) or diagonal_lines(current_player)


def is_whole_line_belong_to_player(current_player, first_element, middle_element, right_element):
    return theBoard[first_element] == theBoard[middle_element] == theBoard[right_element] == current_player


def get_input_from_player():
    global move
    field_not_used = True
    while field_not_used:
        if (move in theBoard) and (theBoard[move] == EMPTY):
            field_not_used = False
        else:
            print('ERROR. try one more time...')
            move = input()


for i in range(9):
    print_board(theBoard)
    print('Turn for ' + turn + ', Move on which space? (Possible moves: ' + get_possible_moves() + ')')
    move = input()

    get_input_from_player()

    theBoard[move] = turn
    if current_player_won(turn):
        print('player ' + turn + ' won')
        print_board(theBoard)
        exit()
    else:
        swap_player()
print('draw ...')
print_board(theBoard)
