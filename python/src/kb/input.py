unit = None
while not unit:
    print('type anything on keyboard to continue:')
    unit = input()

# This an example app to shows that isX string methods are helpful when you need to validate user input.

while True:
    print('Enter title')
    title = input()
    if title.istitle() and len(title) > 1:
        break
    print("title must start from upper case and be longer than 1 character")
