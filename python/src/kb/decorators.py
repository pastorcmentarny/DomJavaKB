# Decorators are a way to change, enhance or alter in any way how a function works.
# Decorators are defined with the @ symbol followed by the decorator name, just before the function definition.
# A decorator is a function that takes a function as a parameter,
# wraps the function in an inner function that performs the job it has to do, and returns that inner function.
# Put simply: decorators wrap a function, modifying its behavior.

# sources: https://realpython.com/primer-on-python-decorators/
def log_time(func):
    def wrapper():
        print('before')
        val = func()
        print('after')
        return val

    return wrapper


@log_time
def log_me():
    print('me')


if __name__ == '__main__':
    log_me()
