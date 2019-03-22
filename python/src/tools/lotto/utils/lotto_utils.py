def get_last(value):
    return value + 1

def validate(numbers):
    if len(numbers) > len(set(numbers)):
        raise ValueError("Numbers are not equal")
    else:
        print("Validation done. Given numbers are unique.")
