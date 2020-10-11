import base64

import pyperclip


def send():
    data = pyperclip.paste()
    encoded = base64.b64encode(data.encode("UTF-8")).decode("UTF-8")[::-1]
    pyperclip.copy(encoded)
    return encoded


def receive():
    data = pyperclip.paste()
    data = data.encode("UTF-8")
    decoded = base64.b64decode(data[::-1]).decode("UTF-8")
    pyperclip.copy(decoded)
    return decoded


# select one and comment out another one
if __name__ == '__main__':
    # print(send())
    print(receive())
