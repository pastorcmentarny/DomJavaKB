# define Python user-defined exceptions
class GobshiteException(Exception):
    print('Shit happens because you have no f..king clue what are you doing! Learn things and fix your mess!')
    pass


class WhoopsException(Exception):
    def __init__(self, message, *args: object):
        super().__init__(*args)
        self.message = message
