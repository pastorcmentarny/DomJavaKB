"""Example can be run from test"""

from retrying import retry

from src.kb.exceptions import GobshiteException, WhoopsException


def retry_on_gobshite_exception(exception):
    return isinstance(exception, GobshiteException)


counter = 1


@retry(retry_on_exception=retry_on_gobshite_exception, wait_exponential_multiplier=100, wait_exponential_max=1000,
       stop_max_attempt_number=5)
def retry_example():
    global counter
    print('executing method..{} time(s)'.format(counter))
    if counter < 3:
        counter += 1
        raise GobshiteException('Whoops')
    else:
        raise WhoopsException('Failed after {} attempted'.format(counter))
